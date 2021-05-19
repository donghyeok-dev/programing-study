package study.chapter01.practice;

public class ReachableTest {

    public static class Refer implements AutoCloseable {

        // https://blog.javarouka.me/2018/11/26/Finalizer%EC%99%80-Cleaner/
        protected void finalize() {
            System.out.println(">> Refer finalize!");
        }

        @Override
        public void close() throws Exception {
            System.out.println(">> Refer closed!");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Refer refer = new Refer();

        System.out.println("gc start");
        System.gc();
        Thread.sleep(1000);
        System.out.println("gc end");

        refer = null; // gc 대상

        System.out.println("gc start");
        System.gc();
        Thread.sleep(1000);
        System.out.println("gc end");

        System.out.println("End!");

    }
}
