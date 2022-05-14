package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {
    public static List<String> split(String names, String delimiter) {
        return Arrays.stream(
                        names.split(delimiter)
                ).map(String::trim)
                .collect(Collectors.toList());
    }
}
