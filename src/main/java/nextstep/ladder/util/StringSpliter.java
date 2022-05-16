package nextstep.ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSpliter {

    private static final String DELIMITER = ",";

    public static List<String> split(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static int length(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .collect(Collectors.toList())
                .size();
    }
}
