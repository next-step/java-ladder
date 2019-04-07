package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static List<String> split(String str) {
        return Arrays.stream(str.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}
