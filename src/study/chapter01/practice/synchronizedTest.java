package study.chapter01.practice;

public class synchronizedTest {
    private static boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
           while(running) {
               //System.out.println("running... " + (++count)); //멈춤
               // 안멈춤
           }
        }).start();

        System.out.println("Thread Start !");
        Thread.sleep(1000);
        running = false;
        System.out.println("Thread Stop !");

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
