package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {

    public static List<String> splitWithComma(String values) {
        return Arrays.stream(values.split(","))
                .collect(Collectors.toList());
    }
}
