package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    public static final String COMMA = ",";

    static List<String> split(String str) {
        return Arrays.stream(str.split(COMMA)).collect(Collectors.toList());
    }
}
