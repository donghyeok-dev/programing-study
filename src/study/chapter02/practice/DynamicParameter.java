package study.chapter02.practice;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class DynamicParameter {
    public static void main(String[] args) {
        //I am a Boy
        System.out.println(joinParameters("I", "am", "a", "Boy"));

        //hello programming world
        System.out.println(convertLowerCaseJoin("Hello", "Programming", "World"));
    }

    public static String joinParameters(String ... params) {
        return String.format("%s", String.join(" ", params));
    }

    public static String convertLowerCaseJoin(String ... params) {
        return Arrays.stream(params)
                .map(s -> s.toLowerCase(Locale.ROOT))
                .collect(Collectors.joining(" "));
    }
}
