import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLockTest {

    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(MyReentrantLockTest::test).start();
        new Thread(MyReentrantLockTest::test).start();
        new Thread(MyReentrantLockTest::test).start();
        new Thread(MyReentrantLockTest::test).start();
    }

    public static void test(){
        for (int i = 0; i < 4; i++) {
            try {
                lock.lock();
                System.out.println("当前线程获取锁："+Thread.currentThread().getName()+" 当前时间戳"+System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
//                System.out.println("当前线程释放锁："+Thread.currentThread().getName()+" 当前时间戳"+System.currentTimeMillis());
            }
        }
    }

}
