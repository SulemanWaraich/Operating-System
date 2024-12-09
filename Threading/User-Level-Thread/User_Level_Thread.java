class UserThread implements Runnable {
    private String taskName;

    public UserThread(String taskName) { // Constructor to initialize the task name.
        this.taskName = taskName;
    }

    @Override
    public void run() { // Defines the thread's behavior when started.
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(taskName + " - Count: " + i); // Print task progress.
                Thread.sleep(500); // Pause for 500ms to simulate work.
            }
        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted");
        }
    }
}

public class User_Level_Thread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new UserThread("Task 1")); // Create a thread wrapping Runnable.
        Thread thread2 = new Thread(new UserThread("Task 2"));

        System.out.println("Starting user-level threads...");
        thread1.start(); // Start thread1; it runs independently.
        thread2.start(); // Start thread2; it runs independently.
    }
}
