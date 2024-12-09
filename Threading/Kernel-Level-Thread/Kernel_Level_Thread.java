class KernelThread extends Thread { // Extends Thread directly.
    private String taskName;

    public KernelThread(String taskName) { // Constructor to initialize the task name.
        this.taskName = taskName;
    }

    @Override
    public void run() { // Define the thread's behavior.
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(taskName + " - Count: " + i); // Print task progress.
                Thread.sleep(700); // Pause for 700ms.
            }
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted");
        }
    }
}

public class Kernel_Level_Thread {
    public static void main(String[] args) {
        KernelThread thread1 = new KernelThread("Kernel Task 1");
        KernelThread thread2 = new KernelThread("Kernel Task 2");

        System.out.println("Starting kernel-level threads...");
        thread1.start(); // Start thread1.
        thread2.start(); // Start thread2.
    }
}
