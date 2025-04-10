package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<String> split(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
