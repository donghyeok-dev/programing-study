package study.chapter01.practice;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        String elementA = "inputA";
        String elementB = "inputB";
        String elementC = "inputC";

        stack.push(elementA);
        stack.push(elementB);
        stack.push(elementC);

        System.out.println(stack.empty()); //빈객체인지 여부
        System.out.println("get element of top : " + stack.peek() + " size: " + stack.size()); //제일 위에 저장된 객체를 가져온다, 꺼내진 않음.
        System.out.println("pop: " + stack.pop() + " size: " + stack.size()); // 제일 위에 객체 꺼냄.

        System.out.println(stack.search(elementC)); // -1, 위에서 pop으로 꺼냈으므로 현재 존재하지 않기 때문에 -1을 리턴.
        System.out.println(stack.search(elementB)); // 1, 찾은 인덱스를 리턴
        System.out.println(stack.search(elementA)); // 2, 찾은 인덱스를 리턴



    }
}

