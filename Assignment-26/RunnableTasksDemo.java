class TableTask implements Runnable {
    private int number;

    public TableTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class CountdownTask implements Runnable {

    @Override
    public void run() {
        for (int i = 5; i >= 1; i--) {
            System.out.println(Thread.currentThread().getName() + " : Countdown " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class RunnableTasksDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TableTask(7), "TableThread");
        Thread t2 = new Thread(new CountdownTask(), "CountdownThread");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Both tasks completed.");
    }
}
