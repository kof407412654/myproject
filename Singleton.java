public class Singleton {

    public static Singleton INSTANCE = SingletonHandler.install;

    private Singleton(){}

    public void checkSingleton(){
        System.out.println("Singleton install success!");
    }

    private static class SingletonHandler{
        private final static Singleton install = new Singleton();
    }

}
