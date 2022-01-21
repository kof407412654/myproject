import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        int athletes = 5;
        CyclicBarrier cb = new CyclicBarrier(athletes, () -> System.out.println("运动员准备完毕"));
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(new AthletesExec(cb));
        }
        executor.shutdown();
    }

    static class AthletesExec implements Runnable {

        private final CyclicBarrier cb;

        AthletesExec(CyclicBarrier cb){
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("运动员" + Thread.currentThread().getName() + "申请出战！");
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
