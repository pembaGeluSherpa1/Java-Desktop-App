package Thread;

public class JoinThread {
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            sleep(2000);
            System.out.println("Hello A");
        });
        a.start();

        Thread b = new Thread(()->{
            sleep(6000);
            System.out.println("Hello B");
        });
        b.start();

        try{
            a.join();
            b.join();
            System.out.println("hello ab");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    static void sleep(long millisecond){
        try{
            Thread.sleep(millisecond);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
