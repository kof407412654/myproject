package myproject;

public class Add10kTest {

    private static Integer count = 0;

    static Integer get(){
        return count;
    }

    static Integer add1(){
        return get()+1;
    }

    static void set(Integer v){
        count = v;
    }

    static synchronized void add10k(){
        for (int i = 0; i < 10000000; i++) {
            set(add1());
        }
    }

    static void print(){
        System.out.println("count="+get());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(Add10kTest::add10k);
        Thread t2 = new Thread(Add10kTest::add10k);
        Thread t3 = new Thread(Add10kTest::add10k);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        print();
    }

}
