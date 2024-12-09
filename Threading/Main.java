class ThreadExample1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task 1: " + i);
        }
    }
}

class ThreadExample2 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task 2: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadExample1 thread1 = new ThreadExample1();
        ThreadExample2 thread2 = new ThreadExample2();

        thread1.start(); // Runs Task 1
        thread2.start(); // Runs Task 2 simultaneously
    }
}
