package fominskiy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounter {

    private static final int ITERATIONS = 10;

     void start() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Counter countOne = new Counter(lock);
        Counter countTwo = new Counter(lock);
        Counter countThree = new Counter(lock);

        Thread thread1 = new Thread(new ThreadCounter(countOne, countThree, ITERATIONS));
        Thread thread2 = new Thread(new ThreadCounter(countTwo, countThree, ITERATIONS));
        Thread thread3= new Thread(new ThreadCounter(countThree, countThree, ITERATIONS));

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Счетчик 1: " + countOne.getNum());
        System.out.println("Счетчик 2: " + countTwo.getNum());
        System.out.println("Счетчик 3: " + countThree.getNum());
    }

    private class ThreadCounter implements Runnable {
        private final Counter counterOne;
        private final Counter counterTwo;
        private final int iterations;

        public ThreadCounter(Counter count1, Counter count2, int iter) {
            this.counterOne = count1;
            this.counterTwo = count2;
            this.iterations = iter;
        }

        @Override
        public void run() {
            for (int i = 0; i < iterations; i++) {
                counterOne.incrementAndGet();
                counterTwo.incrementAndGet();
            }
        }
    }

    private static class Counter {
        private long num;
        private final Lock lock;

        public Counter(Lock lock) {
            this.lock = lock;
        }

        public long getNum() {
            return num;
        }

        public void incrementAndGet() {
            incrementAndGet(1L);
        }

        public void incrementAndGet(long increment) {
            try {
                lock.lock();
                this.num += increment;
            } finally {
                lock.unlock();
            }
        }
    }
}
