class NumberThread extends Thread {

    public NumberThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " -> " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted");
            }
        }
        System.out.println(getName() + " finished");
    }
}

public class MultiThreadNumbers {

    public static void main(String[] args) throws InterruptedException {
        NumberThread t1 = new NumberThread("Thread-A");
        NumberThread t2 = new NumberThread("Thread-B");
        NumberThread t3 = new NumberThread("Thread-C");

        System.out.println("Thread-A state after creation : " + t1.getState());

        t1.start();
        t2.start();
        t3.start();
        System.out.println("Thread-A state after start()  : " + t1.getState());

        Thread.sleep(200);
        System.out.println("Thread-A state while sleeping : " + t1.getState());

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Thread-A state after join()   : " + t1.getState());
        System.out.println("All threads have completed.");
    }
}
