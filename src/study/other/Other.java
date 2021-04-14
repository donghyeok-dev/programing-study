package study.other;

public class Other {
    private final String name = "abc";
    /*
    final 변수는 초기값을 지정하거나 생성자에서 초기화 하지 않으면 컴파일 에러가 발생한다.

    public Other() {
        this.name = "aaa";
    }

    public Other(String name) {
        this.name = name;
    }*/

    static {
        System.out.println("static message");
    }

    private void printHi() {
        System.out.println("private message");
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Fuc!";
    }

    public static void main(String[] args) {
        Other other = new Other();
        other.printHi();
        System.out.println(other.toString());
    }

}
