import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    static final int MAX = 10_000_000;
    static AtomicInteger sharedData = new AtomicInteger(0);

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
        System.out.println("Final value of sharedData: " + sharedData.get());
    }

    static class Increment implements Runnable {
        public void run() {
            for (int i = 0; i < MAX; i++) {
                sharedData.incrementAndGet();
            }
        }
    }

    static class Decrement implements Runnable {
        public void run() {
            for (int i = 0; i < MAX; i++) {
                sharedData.decrementAndGet();
            }
        }
    }
}
