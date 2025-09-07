package Thread;

public class DeadLock {
    static Object obj1 = new Object();
    static Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (obj1){
                System.out.println("yo"+Thread.currentThread().getName()+"yooo");

                synchronized(obj2){
                    System.out.println("Thread 1 yo obj2");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (obj2){
                System.out.println("yo"+Thread.currentThread().getName()+"started");

                synchronized(obj1){
                    System.out.println("Thread 2 yo obj1");
                }
            }
        }).start();

        System.out.println("dead lock");
    }
}
