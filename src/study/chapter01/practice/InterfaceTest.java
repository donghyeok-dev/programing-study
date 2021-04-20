package study.chapter01.practice;

import study.other.DefaultStaticInterface;

public class InterfaceTest implements DefaultStaticInterface {
    @Override
    public int plus(int i, int j) {
        return i + j;
    }
}
