package nextstep.ladder.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {

    private StringParser() {
    }

    private static final String DEFAULT_PATTERN = ",";

    public static List<String> split(String text) {
        return Stream.of(text.split(DEFAULT_PATTERN))
                .collect(Collectors.toList());
    }

}
