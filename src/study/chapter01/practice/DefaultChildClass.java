package study.chapter01;

import study.other.PublicOtherClass;

public class DefaultChildClass extends PublicOtherClass {

    //protected 변수는 상속 관계이면 다른 패키지라도 접근이 가능함.
    public String getProtectedValue() {
        return this.protectedValue;
    }

    //default 변수는 상속 관계일지라도 같은 패키지가 아니면 접근할 수 없음.
//    public String getDefaultValue() {
//        return this.defaultValue;
//    }
}
