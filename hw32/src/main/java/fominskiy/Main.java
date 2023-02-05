package fominskiy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCounter threadSafeCounter = new ThreadSafeCounter();
        threadSafeCounter.start();
    }
}
