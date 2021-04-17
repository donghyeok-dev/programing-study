package study.other;

/**
 *  기존에는 interface가 추상 메서드만 가질수 있었는데
 *  Java 8버전부터  default, static 메서드를 정의할 수 있도록 변경되었습니다.
 */
public interface DefaultStaticInterface {
    public int plus(int i, int j);

    default int exec(int i, int j) {
        return i + j;
    } //interface를 구현한 구현체의 instance에서 호출할 수 있음.

    public static int exe2(int i, int j) {           //interface명.exe2(3,4) 형태로 interface에서 직접 접근할 수 있음. (utility성 인터페이스)
        return i + j;
    }
}
