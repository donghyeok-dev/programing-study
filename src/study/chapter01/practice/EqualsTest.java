package study.chapter01.practice;

public class EqualsTest {

    public static void main(String[] args) {
        String value1 = "123";
        String value2 = "123";
        String value3 = new String("123");

        /*
            String 변수는 String constant pool에 값을 보관하며 같은 값을 할당하면 변수는 같은 참조값을 가진다.
            intern() 메서드가 String constant pool를 조회하여 존재하면 객체를 반환하고 아니면 등록합니다.
        */
        System.out.println(value1 == value2); // true

        /*
            String constant pool은 Heap 영역에 존재하고, new String으로 생성한 객체 또한 Heap영역에 존재하지만
            서로 다른 메모리 객체로 존재하기 때문에 메모리 객체 주소 값을 비교하는 ==  때문에 false가 나오게 되는 것입니다.
        */
        System.out.println(value1 == value3); // false

        /*
            equals() 메서드는 변수 타입의 클래스 내에 equals() 메서드를 호출하여 결과를 리턴 받습니다.
            String 클래스 내 equals 함수는 아래와 같이 구현되어 있습니다.
            public boolean equals(Object anObject) {
                if (this == anObject) {
                    return true;
                }
                if (anObject instanceof String) {
                    String aString = (String)anObject;
                    if (coder() == aString.coder()) {
                        return isLatin1() ? StringLatin1.equals(value, aString.value)
                                          : StringUTF16.equals(value, aString.value);
                    }
                }
                return false;
            }
         */
        System.out.println(value1.equals(value2)); // true
        System.out.println(value1.equals(value3)); // true

        /*
            StringBuilder의 toString()은 객체를 생성하므로 == 를 사용할 수 없다.
            public String toString() {
                // Create a copy, don't share the array
                return isLatin1() ? StringLatin1.newString(value, 0, count)
                                  : StringUTF16.newString(value, 0, count);
            }
         */
        StringBuilder builder1 = new StringBuilder();
        builder1.append("123");
        System.out.println(builder1.toString() == value1);
        System.out.println(builder1.toString().equals(value1));

    }
}
