package myproject;

public class ThreadTest {

    private static int i = 0;

    public static void main(String[] args) {
        Thread a = new Thread(ThreadTest::count);
        Thread b = new Thread(ThreadTest::count);
        a.start();
        b.start();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i="+i);
    }
    public static void count(){
        synchronized (ThreadTest.class){
            for (int j = 0; j < 100000000; j++) {
                i++;
            }
        }
    }
}
