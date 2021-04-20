package study.chapter01.practice;

public class AbstractInterface {
    public static void main(String[] args) {
        TestInterface testInterface = new TestClass();
        System.out.println(testInterface.plus(3, 4));
        System.out.println(testInterface.minus(3, 4));
        System.out.println(TestInterface.NUM);

        TestInterface testInterface2 = new TestInterface() {
            @Override
            public int plus(int a, int b) {
                return a+b;
            }

            @Override
            public int minus(int a, int b) {
                return a-b;
            }
        };

        System.out.println(testInterface2.plus(5, 10));

        AbstractTestClass abstractTestClass  = new TestClass();
        System.out.println(abstractTestClass.multiple(3, 4));
        abstractTestClass.print(3,4);

        AbstractTestClass abstractTestClass2 = new AbstractTestClass() {
            @Override
            public int multiple(int a, int b) {
                return a * b;
            }
        };

        System.out.println(abstractTestClass2.multiple(5, 6));
        abstractTestClass2.print(5, 6);
    }
}

interface TestInterface {
    public static final int NUM=3;
    public int plus(int a, int b);

    public int minus(int a, int b);
    //private, protected 접근제어자를 사용할수 없음.
}

class TestClass extends AbstractTestClass implements TestInterface {

    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }

    @Override
    public int multiple(int a, int b) {
        return a * b;
    }
}

abstract class AbstractTestClass {
    private int privateValue = 1;
    protected int protectedValue = 2;
    public int publicValue = 3;

    public abstract int multiple(int a, int b);
    public void print(int a, int b) {
        System.out.println(a + ", " + b);
    }

}
