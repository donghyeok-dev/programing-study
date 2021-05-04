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

//    public static synchronized int getCount() {
//        return s_count;
//    }
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

//        t.start();
//        t2.start();
//        t3.start();

        System.out.println("Thread Start !");
        Thread.sleep(100);

        setRunning(false);
        running.set(false);

        System.out.println("Thread Stop !");
        System.out.println(">> count after: " + count.get());
    }

    public static void test1() {
        System.out.println("Test start!");

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    callMe("Thread1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    callMe("Thread2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("Test end!");
    }
    public static synchronized void callMe(String msg) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Call Me! : " + msg);
    }
}
