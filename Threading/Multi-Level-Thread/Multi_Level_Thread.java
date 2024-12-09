class InnerTask implements Runnable {
    private String taskName;

    public InnerTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() { // Behavior of inner threads.
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - Step " + i);
            try {
                Thread.sleep(300); // Pause for 300ms.
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted");
            }
        }
    }
}

class OuterTask extends Thread {
    private String taskName;

    public OuterTask(String taskName) { // Constructor to initialize task name.
        this.taskName = taskName;
    }

    @Override
    public void run() { // Outer thread behavior.
        System.out.println(taskName + " starting...");
        Thread innerThread = new Thread(new InnerTask(taskName + " - Inner Task"));
        innerThread.start(); // Start the inner thread.

        try {
            innerThread.join(); // Wait for the inner thread to finish.
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted");
        }

        System.out.println(taskName + " completed.");
    }
}

public class Multi_Level_Thread {
    public static void main(String[] args) {
        OuterTask outerTask1 = new OuterTask("Outer Task 1");
        OuterTask outerTask2 = new OuterTask("Outer Task 2");

        System.out.println("Starting multi-level threads...");
        outerTask1.start(); // Start the first outer thread.
        outerTask2.start(); // Start the second outer thread.
    }
}
