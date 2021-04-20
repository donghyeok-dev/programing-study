package study.chapter01.practice;

import study.other.TestDto;

public class Memory {
    static int a = 0;

    public static void main(String[] args) {
        String msg = "Hello"; // Heap Segment에 저장됨.
        TestDto dto = new TestDto();

        dto.setName("My");

        addMethod(msg, dto);

        /*
        참조 객체로 전달된 dto만 메서드 내에서 변경한 값을 유지하고,
        값 복사로 새롭게 생성된 변수는 메서드 내부에서 결과를 출력하고 함수 종료와 함께 GC 대상이 된다.
         */
        System.out.println("[Main] dto: " + dto.getName()); // My Love~
        System.out.println("[Main] msg: " + msg); // Hello
    }

    /**
     * @param msg : call-by-value : 새로운 객체를 생성한다.
     * @param dto : call-by-reference : 기존 객체를 참조하고 있는 참조 객체를 생성한다.(포인터 개념)
     */
    public static void addMethod(String msg, TestDto dto) {
        dto.setName(dto.getName() + " Love~");
        msg += " world!";

        System.out.println("[addMethod] dto: " + dto.getName()); // My Love~
        System.out.println("[addMethod] msg: " + msg); // Hello world!
    }
}
