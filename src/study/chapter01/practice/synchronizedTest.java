package study.chapter01.practice;

public class synchronizedTest {

    public static void main(String[] args) {

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
