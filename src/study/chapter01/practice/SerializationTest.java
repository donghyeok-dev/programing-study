package study.chapter01.practice;

import lombok.ToString;

import java.io.*;

public class SerializationTest {
    public static void main(String[] args) {
        final String FILE_PATH =  "C:\\Users\\mosic\\IdeaProjects\\programing-study\\src\\study\\chapter01\\practice\\test.serialization.cv";
        
        //직렬화
        /*try (FileOutputStream   fos = new FileOutputStream (FILE_PATH);
             ObjectOutputStream oos =new ObjectOutputStream (fos);
        ) {
            Apple apple = new Apple();
            oos.writeObject(apple);

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // 역직렬화
        try(FileInputStream fis=new FileInputStream(FILE_PATH);
            ObjectInputStream ois=new ObjectInputStream(fis);
        ) {
            Apple response=(Apple)ois.readObject();

            System.out.println(response);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
    implements Serializable를 안하면 런타임 예외 발생함.
    java.io.NotSerializableException: study.chapter01.practice.SerializationTest$Apple

    직렬화 -> 직렬화 부분 주석 & Apple 클래스 필드 추가 -> 역직렬화하면 아래 처럼 오류
    InvalidClassException: study.chapter01.practice.SerializationTest$Apple; local class incompatible: stream classdesc serialVersionUID = -88973244
    
    다시 직렬화 -> ... 위 과정 반복해보면
    Apple에 직렬화 버전 정보를 추가하면 오류가 없어짐.

    serialVersionUID는 직렬화&역직렬화 하는데 있어 식별ID로 사용되기 때문에
    직렬화 -> 필드 변화 -> 역직렬화해도 정상 작동하게 된다.
     */
    @ToString
    static class Apple implements Serializable{
        private static final long serialVersionUID = 1L;

        int amount = 1000;
        String location = "청송";
        static String cDate = "2021-05-17";
        transient String cDate2 = "2021-05-17";
        int temp;
        int temp2;
    }
}
