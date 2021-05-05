package study.chapter01.practice;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class synchronizedTest {
    private static AtomicBoolean running = new AtomicBoolean(true);
    private static AtomicInteger count = new AtomicInteger(0);

    private static boolean s_running = true;
    private static int s_count = 0;

    public static synchronized boolean getRunning() {
        return s_running;
    }
    public static synchronized void setRunning(boolean val) {
        s_running = val;
    }

    public static synchronized int incrementCount(String user) {
        s_count += 1;
        System.out.println(">> incrementCount s_count: " + s_count + " > " + user);
        return s_count;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread s = new Thread(() -> {
            while (getRunning()) {
                System.out.println("S1 Running... " + incrementCount("S1"));
            }
        });

        Thread s2 = new Thread(() -> {
            while (getRunning()) {
                System.out.println("S2 Running... " + incrementCount("S2"));
            }
        });

        Thread s3 = new Thread(() -> {
            while (getRunning()) {
                System.out.println("S3 Running... " + incrementCount("S3"));
            }
        });

        Thread t = new Thread(() -> {
           while(running.get()) {
               count.incrementAndGet();
               System.out.println("T1 Running... " + count.get());

           }
        });

        Thread t2 = new Thread(() -> {
            while(running.get()) {
                count.incrementAndGet();
                System.out.println("T2 Running... " + count.get());

            }
        });

        Thread t3 = new Thread(() -> {
            while(running.get()) {
                count.incrementAndGet();
                System.out.println("T3 Running... " + count.get());

            }
        });

        s.start();
        s2.start();
        s3.start();

        t.start();
        t2.start();
        t3.start();

        System.out.println("Thread Start !");
        Thread.sleep(100);

        setRunning(false);
        running.set(false);

        System.out.println("Thread Stop !");
        System.out.println(">> count after: " + count.get());

        SynchronizedBlockTestClass obj = new SynchronizedBlockTestClass();

        Thread b = new Thread(() -> {
            while (obj.getRunning()) {
                obj.incrementCount();
                System.out.println("B1 Running... " + obj.getCounter());
            }
        });

        Thread b2 = new Thread(() -> {
            while (obj.getRunning()) {
                obj.incrementCount();
                System.out.println("B2 Running... " + obj.getCounter());
            }
        });

        Thread b3 = new Thread(() -> {
            while (obj.getRunning()) {
                obj.incrementCount();
                System.out.println("B3 Running... " + obj.getCounter());
            }
        });

        b.start();
        b2.start();
        b3.start();
        Thread.sleep(100);
        obj.setRunning(false);

    }
}

class SynchronizedBlockTestClass {
    private int counter = 0;
    private boolean running = true;

    public int getCounter() {
        synchronized (this) {
            return this.counter;
        }
    }
    public void incrementCount() {
        synchronized (this) {
//            System.out.println(">> incrementCount user: " + user);
            ++this.counter;
        }
    }

    public boolean getRunning() {
        synchronized (this) {
            return this.running;
        }
    }

    public void setRunning(boolean val) {
        synchronized (this) {
            this.running = val;
        }
    }
}
