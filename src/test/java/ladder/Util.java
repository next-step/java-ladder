package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static List<String> parsedStringList(String string) {
        return Arrays.stream(string.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Integer> parsedIntegerList(String string) {
        return Arrays.stream(string.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
