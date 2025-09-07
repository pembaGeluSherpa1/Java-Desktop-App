package Thread;

class ThreadA extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Running thread " + i + " From Class A");
        }
        System.out.println("Exit from Class A");
    }
}

class ThreadB extends Thread {
    public void run() {
        for (int j = 1; j <= 5; j++) {
            System.out.println("Running thread " + j + " From Class B");
        }
        System.out.println("Exit from Class B");
    }
}

class ThreadC extends Thread {
    public void run() {
        for (int k = 1; k <= 5; k++) {
            System.out.println("Running thread " + k + " From Class C");
        }
        System.out.println("Exit from Class C");
    }
}

public class PriorityThread {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();
        ThreadB t2 = new ThreadB();
        ThreadC t3 = new ThreadC();

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(t1.getPriority() + 1); // OR t2.setPriority(2);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}