package study.chapter01;

import study.other.DefaultStaticInterface;

public class InterfaceTest implements DefaultStaticInterface {
    @Override
    public int plus(int i, int j) {
        return i + j;
    }
}
