package fominskiy;

import static java.lang.Thread.sleep;

public class PingPong {

    void start() {
        Thread ping = new Thread(new ThreadWord(), "ping");
        ping.start();
        Thread pong = new Thread(new ThreadWord(), "pong");
        pong.start();
    }

    protected class ThreadWord implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    wordPlay();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    synchronized void wordPlay() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        sleep(300);
        notify();
        wait();
    }
}
