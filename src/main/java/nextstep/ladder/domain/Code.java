package nextstep.ladder.domain;

import java.util.Arrays;

public enum Code {
    ALL, EXIT;

    public static boolean contains(String input) {
        return Arrays.stream(values())
                .anyMatch(i -> input.equalsIgnoreCase(String.valueOf(i)));
    }
}
