package study.chapter01;

public class Memory {
    static int a = 0;

    public static void main(String[] args) {
        //-- Stack Segment main------------------->
        String msg = "hello"; // Heap Segment에 저장됨.

        System.out.println("[Main] " +Integer.toHexString(System.identityHashCode(msg))); // 27f674d (참조주소)

        addMethod(msg);
        /* 함수가 종료되면 msg의 참조주소가 바뀌는 것은
           사실 처음부터 addMethod와 Main 메서드는 Stack 내에서 서로 다른 공간에 할당되어 있었기 때문입니다.
           메서드 내에 할당된 참조값들은 heap에 생성되는데 이를 각각 참조하다가 addMethod가 종료되면서 스택포인터가 Main을 가르키고
           Main의 msg가 보이게 되는 것입니다.
            |       Stack        |                   Heap
            ---------------------
            |       Main        | --------------->  "hello"
            |       addMethod   | --------------->  "hello world!"

         */

        System.out.println("[Main] " + Integer.toHexString(System.identityHashCode(msg))); // 27f674d (참조주소)

        System.out.println(msg); // hello 2021
    }

    public static void addMethod(String msg) {
        //-- Stack Segment addMethod------------------->
        System.out.println("[addMethod] " + Integer.toHexString(System.identityHashCode(msg))); // 27f674d

        msg += " world!";  // Heap Segment의 새로운 공간에 생성되고, addMethod의  msg는 새로운 공간을 가르킴.

        System.out.println("[addMethod] " + Integer.toHexString(System.identityHashCode(msg))); // 1a407d53

        System.out.println(msg); // hello world!
    }
}
