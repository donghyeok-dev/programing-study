package study.chapter01;

import java.math.BigInteger;

public class DataType {
    public static void main(String[] args) {
        System.out.println("byte: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println("short: " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
        System.out.println("int: " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println("long: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
        System.out.println("float: " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
        System.out.println("Double: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
        /* 결과
        byte: -128 ~ 127
        short: -32768 ~ 32767
        int: -2147483648 ~ 2147483647
        long: -9223372036854775808 ~ 9223372036854775807
        float: 1.4E-45 ~ 3.4028235E38
        Double: 4.9E-324 ~ 1.7976931348623157E308
        */

        double sum = 0;

        for (int i = 0; i < 1000; i++) {
            sum += 0.1;
        }

        System.out.println(" sum: " + sum);
        /* 결과
        sum: 99.9999999999986
        0.1을 1000번 더한 합계는 100이 되어야 하지만, 근사값이 출력된다.
         */
    }
}


