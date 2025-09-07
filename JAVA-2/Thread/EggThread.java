package Thread;

public class EggThread {
    public static void main(String[] args) {
        ScoreKeeper score = new ScoreKeeper();
        System.out.println("hello1");


        Thread[] t2Array = new Thread[20];
            for(int i=0;i<20;i++){
                t2Array[i] = new Thread(()->{
                    score.decrement();
                });
                t2Array[i].start();
            }
            // for(Thread t2 : t2Array){
            //     try{
            //         t2.join();
            //         System.out.println("the score "+score.score);
            //     }catch(InterruptedException e){
            //         e.printStackTrace();
            //     }
            // }
            // System.out.println("hello");
    }
}

class ScoreKeeper{
    int score =5;
    synchronized void decrement(){
        if(score>0){
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            score = score-1;
            // System.out.println("The score is "+score);
        }
    }
}
