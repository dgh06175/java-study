import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    static final int MAX = 10_000_000;
    static int sharedData = 0;
    static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        long startTime = System.nanoTime(); // 시간 측정 시작

        Thread thread1 = new Thread(new Increment());
        Thread thread2 = new Thread(new Decrement());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }

        long endTime = System.nanoTime(); // 시간 측정 끝
        long duration = endTime - startTime; // 걸린 시간 (나노초 단위)
        System.out.println("Execution Time: " + duration / 1_000_000 + " ms");
        System.out.println("Final value of sharedData: " + sharedData);
    }

    static class Increment implements Runnable {
        public void run() {
            for (int i = 0; i < MAX; i++) {
                try {
                    semaphore.acquire();
                    sharedData++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        }
    }

    static class Decrement implements Runnable {
        public void run() {
            for (int i = 0; i < MAX; i++) {
                try {
                    semaphore.acquire();
                    sharedData--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        }
    }
}
