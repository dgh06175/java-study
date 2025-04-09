import java.util.concurrent.locks.*;

public class Main {
    static final int MAX = 100000;
    static int sharedData = 0;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Increment());
        Thread thread2 = new Thread(new Decrement());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("Final value of sharedData: " + sharedData);
    }

    static class Increment implements Runnable {
        public void run() {
            for (int i = 0; i < MAX; i++) {
                lock.lock();
                try {
                    sharedData++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Decrement implements Runnable {
        public void run() {
            for (int i = 0; i < MAX; i++) {
                lock.lock();
                try {
                    sharedData--;
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
