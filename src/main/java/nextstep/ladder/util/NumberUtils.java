package nextstep.ladder.util;

import java.util.regex.Pattern;

public class NumberUtils {

    private static final String NOT_NUMBER = "입력값은 숫자 값이어야 합니다 -> %s";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static void requireNumber(final String number) {
        if (!isNumber(number)) {
            throw new IllegalArgumentException(String.format(NOT_NUMBER, number));
        }
    }

    public static boolean isNumber(final String number) {
        return NUMBER_PATTERN.matcher(number).matches();
    }

    public static void printNotNumber(final String number) {
        System.out.println(String.format("\n" + NOT_NUMBER, number));
    }
}
