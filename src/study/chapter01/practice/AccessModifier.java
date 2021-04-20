package study.chapter01;

import study.other.DefaultStaticInterface;
import study.other.PublicOtherClass;

public class AccessModifier {

    public static void main(String[] args) {
        DefaultClass defaultClass = new DefaultClass(); //같은 패키지 내에 클래스에서는 default 클래스의 instance를 만들 수 있음.
//        DefaultOtherClass defaultOtherClass = new DefaultOtherClass(); //다른 패키지에 default 클래스는 참조할 수 없음.
        PublicOtherClass publicOtherClass = new PublicOtherClass(); //다른 패키지의 public 클래스는 instance를 만들 수 있음.

        //private 변수는 클래스 내에서만 접근 가능.
        System.out.println(defaultClass.publicValue);    //같은 패키지내의 클래스의 public 변수는 접근이 가능함.
        System.out.println(defaultClass.protectedValue); //같은 패키지내의 클래스의 protected 변수는 접근이 가능함.
        System.out.println(defaultClass.defaultValue);   //같은 패키지내의 클래스의 default 변수는 접근이 가능함.

        System.out.println(publicOtherClass.publicValue);    //다른 패키지내의 클래스의 public 변수는 접근이 가능함.
//        System.out.println(publicOtherClass.protectedValue); //다른 패키지내의 클래스의 protected 변수는 접근 불가.
//        System.out.println(publicOtherClass.defaultValue);   //다른 패키지내의 클래스의 default 변수는 접근 불가.

        DefaultChildClass defaultChildClass = new DefaultChildClass(); //다른 패키지의 PublicOtherClass를 상속 받은 클래스
        //같은 패키지내의 클래스가 다른 패키지 클래스를 상속 받은 경우 public만 직접 접근가능하고,
        // 클래스 내 protected 변수는 public 메서드를 통해 접근 할 수 있음.
        System.out.println(defaultChildClass.publicValue);    //접근이 가능함.
//        System.out.println(defaultChildClass.protectedValue); //접근이 불가.
//        System.out.println(defaultChildClass.defaultValue);   //접근이 불가.

        //PublicOtherClass를 상속받은 DefaultChildClass객체에서 public 메서드로 PublicOtherClass의 protected 변수에 접근할 수 있음.
        System.out.println(defaultChildClass.getProtectedValue());

        //PublicOtherClass의 default 변수는  DefaultChildClass가 상속관계일지라도 접근이 불가함.

        /**
         *  기존에는 interface가 추상 메서드만 가질수 있었는데
         *  Java 8버전부터  default, static 메서드를 정의할 수 있도록 변경되었습니다.
         *  인터페이스를 상속 받으면 불필요한 메서드까지 모두 구현해야되는 문제를 해결하고자 추가되었습니다.
         */
        InterfaceTest interfaceTest = new InterfaceTest();

        System.out.println(interfaceTest.plus(3, 4)); //인터페이스의 구현체 클래스에서 정의된 메서드 호출
        System.out.println(interfaceTest.exec(3, 4)); //인터페이스에 정의된 default 메서드 호출.
        System.out.println(DefaultStaticInterface.exe2(3, 4)); //인터페이스에 정의된 static 메서드는 인터페이스에서 직접 호출해야 됨.

    }
}


