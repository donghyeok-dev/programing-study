package study.chapter01.practice;

import lombok.ToString;

import java.io.*;

public class SerializationTest {
    public static void main(String[] args) {
        final String FILE_PATH =  "C:\\Users\\mosic\\IdeaProjects\\programing-study\\src\\study\\chapter01\\practice\\test.serialization.cv";
        
        //직렬화
        try (FileOutputStream   fos = new FileOutputStream (FILE_PATH);
             ObjectOutputStream oos =new ObjectOutputStream (fos);
        ) {
            Apple apple = new Apple();
            oos.writeObject(apple);

        } catch (IOException e) {
            e.printStackTrace();
        }

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
     */
    @ToString
    static class Apple implements Serializable{
        int amount = 1000;
        String location = "청송";
        static String cDate = "2021-05-17";
        transient String cDate2 = "2021-05-17";
    }
}
