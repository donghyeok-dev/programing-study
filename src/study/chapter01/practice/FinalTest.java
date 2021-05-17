package study.chapter01.practice;

public class FinalTest {
    static final int globalValue;

    static {
        globalValue = 1;
    }

    public static void main(String[] args) {


        /*String test1 = "main1"에서 "main1" 값은 String 타입이므로 참조하고 있는 메모리의 값이 변경되지 않습니다.
         이와 같이 변하지 않는 값 구 자체를 리터럴(literal)이라고 합니다.

         상수(Constant)는 변하지 않는 변수를 뜻합니다. 변수에 final 키워드를 사용합니다.
         */
        final String test1 = "main1";
        final InnerTest test2 = new InnerTest();

        System.out.println(test1);
        // test1 = "@22"; //cannot assign a value to final variable test1

        // final로 지정한다고 해서 객체가 참조하고 있는 객체까지 final로 지정되지 않기 때문에 수정이 가능함.
        System.out.println(test2.innerValue1);
        test2.innerValue1 = "change value";
        System.out.println(test2.innerValue1);
        test2.print("nice");
        test2.value1 = 300000000;
        // test2.innerValue2 = "can't change value"; //cannot assign a value to final variable test1

        final InnerSubTest test3 = new InnerSubTest();
        test3.print2("ggg");
    }
}

class InnerTest {
    protected int value1 = 12;
    protected String innerValue1 = "inner1";
    protected final String innerValue2;
    private String innerValue3 = "aaa";

    InnerTest() {
        innerValue2="111";
    }

    final void print(final String message) {
        System.out.println("InnerTestClass print Method! : " + message);
    }

    void print2(final String message) {
        System.out.println("InnerTestClass print Method! : " + message);
    }
}

final class InnerSubTest extends InnerTest {

    /* InnerTest의 print메서드가 final로 정의되었기 때문에 override할 수 없음
    void print(String message) {
        System.out.println("InnerSubTest print " + message);
    }*/

    @Override
    void print2(final String message) {
        System.out.println("InnerSubTest print Method! : " + message);
    }

}

/* InnerSubTest는 final로 선언되었기 때문에 다른 클래스에서 상속 받을 수 없습니다. 컴파일 오류가 발생함.
class InnerSub2 extends InnerSubTest {

}
 */