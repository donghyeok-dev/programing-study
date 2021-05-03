package study.chapter01.practice;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class synchronizedTest {
    private static AtomicBoolean running = new AtomicBoolean(true);
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

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

        t.start();
        t2.start();
        t3.start();
        System.out.println("Thread Start !");
        Thread.sleep(100);
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
