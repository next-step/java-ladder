package laddergame.util;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Parser {
    private Parser() {
    }

    public static List<String> parse(String input, String delimiter) {
        validateNullOrEmpty(input);
        return Arrays.asList(input.split(delimiter));
    }

    private static void validateNullOrEmpty(String names) {
        if (Objects.isNull(names) || names.isEmpty()) {
            throw new LadderGameException(ErrorCode.NULL_OR_EMPTY_INPUT);
        }
    }
}
