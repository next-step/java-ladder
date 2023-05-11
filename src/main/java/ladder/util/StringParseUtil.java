package ladder.util;

import java.util.Arrays;

public class StringParseUtil {

    public static int parseToInt(String input){
        return Integer.parseInt(input);
    }
    public static String[] splitString(String input, String delimiter){
        return trimString(input.split(delimiter));
    }

    public static String[] trimString(String[] input){
        return Arrays.stream(input)
                .map(String::trim)
                .toArray(String[]::new);
    }

}
