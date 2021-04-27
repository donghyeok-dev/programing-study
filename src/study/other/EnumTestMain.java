package study.other;

public class EnumTestMain {
    public static void main(String[] args) {
        EnumTest<TestEnum> enumTest = new EnumTest<>(TestEnum.class);
        System.out.println("code: " + EnumTest.getCode(TestEnum.KOREA));
        System.out.println("codeName : " + enumTest.getCodeName(TestEnum.KOREA.getCode()));

        EnumTest<TestBEnum> enumBTest = new EnumTest<>(TestBEnum.class);
        System.out.println("code: " + EnumTest.getCode(TestBEnum.COMPUTER));
        System.out.println("codeName : " + enumBTest.getCodeName(TestBEnum.COMPUTER.getCode()));


    }
}
