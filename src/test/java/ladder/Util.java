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
}
