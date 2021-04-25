package study.chapter01.practice;

import java.util.Scanner;

public class Operator {

    public static void main(String[] args) {
        int a = 0;
        System.out.println("a++: " + a++); //0 증감연산자가 뒤에 붙으면 다음 a가 사용될때부터 증감된 값을 사용할 수 있음.
        System.out.println("a: " + a);   //1
        System.out.println("++a: " + ++a); //2 증감 연산자가 앞에 와야 증가된 수를 사용할 수 있음.

        //shift연산자
        System.out.println("2 << 3: " + (2 << 3)); // 2^(1+3) = 2^4 = 16
        System.out.println("4 << 5: " + (4 << 5)); // 2^(2+5) = 2^7 = 128

        System.out.println("8 >> 2: " + (8 >> 2)); // 2^(3-2) = 2^1 = 2
        System.out.println("8 >> 5: " + (8 >> 5)); // 2^(3-4) = 2^-1 = 0

        System.out.println("-8 >> 2: " + (-8 >> 2)); //-2 , 음수인 경우 부호를 유지시켜주기 위해서 빈자리를 1로 채웁
        System.out.println("-8 >>> 2: " + (-8 >>> 2)); //1073741822 ,  부호에 상관없이 항상 0으로 빈자리를 채워줍니다.
        System.out.println(Integer.toBinaryString((-8 >>> 2))); //111111111111111111111111111110

        //논리연산자
        System.out.println("1==1 && 1==2: " + (1==1 && 1==2)); // false
        System.out.println("1==1 || 1==2: " + (1==1 || 1==2)); // true
        System.out.println("(8 | 4): " + (8 | 4)); // 12, 00001000 OR연산 00000100
        System.out.println("(8 & 4): " + (8 & 4)); // 0,  00001000 AND연산 00000100
        System.out.println("(8 ^ 4): " + (8 ^ 4)); // 0,  00001000 XOR연산 00000100
        System.out.println(" ~ :" + ~2); //-3 ,  NOT연산 , 00000010 -> 11111101-> 1의 보수(00000010) -> 2의 보수(00000011) + -부호


        //나머지 구하는 산술연산자
        System.out.println("4 % 2: " + 4 % 2); // 0
        System.out.println("1 % 2: " + 1 % 2); // 1
        System.out.println("1 % 100000001: " + 1 % 100000001); // 1
        System.out.println("1 % 0: " + 1 % 0); // ArithmeticException: / by zero
        System.out.println("0 % 1: " + 0 % 1); // 0

    }

    public static void testScanner() {
        Scanner a = new Scanner(System.in);
        System.out.print("input number: ");
        String text = a.next();
        System.out.println(text);
    }
}
