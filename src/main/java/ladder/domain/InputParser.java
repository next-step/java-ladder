package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static final String splitPattern = "[,][ ]?";

    private InputParser() {
    }

    public static List<String> parseRawInput(String input) {
        return Arrays.stream(input.split(splitPattern))
                .collect(Collectors.toList());
    }
}
