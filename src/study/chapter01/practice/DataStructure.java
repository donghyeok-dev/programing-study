package study.chapter01.practice;

import java.util.*;

public class DataStructure {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>(10);
        /*
        스레드 안전 구현이 필요하지 않은 경우 벡터 대신 ArrayList를 사용하는 것이 좋습니다.
         */
        Vector<String> vector = new Vector<>(10); //쓰래드 세이프

        arrayList.add("test1");
        arrayList.add("test2");
        arrayList.add("test3");

        vector.add("test1");
        vector.add("test2");
        vector.add("test3");

        arrayList.forEach(System.out::println);
        vector.forEach(System.out::println);

        //ArrayList 동기화해서 사용하기
        List<String> synchronizedList =  Collections.synchronizedList(new ArrayList<String>());
        synchronizedList.add("test1");
        synchronizedList.add("test2");
        synchronizedList.add("test3");

        synchronized(synchronizedList) {
            synchronizedList.forEach(System.out::println);
        }
    }
}
