package laddergame.util;

import java.util.regex.Pattern;

import static java.util.Objects.nonNull;

public class Validator {
    private static final Pattern PATTERN_FOR_POSITIVE_INTEGER = Pattern.compile("^([1-9][0-9]*)$");

    public static boolean isNonBlank(String stringInput) {
        return nonNull(stringInput) && !stringInput.isBlank();
    }

    public static boolean isValidStringLength(String stringInput, int maxStringLength) {
        return isNonBlank(stringInput) && stringInput.length() <= maxStringLength;
    }

    public static boolean isPositiveInteger(String numberString) {
        return isNonBlank(numberString) && PATTERN_FOR_POSITIVE_INTEGER.matcher(numberString).find();
    }


    public static boolean isGreaterThanStandard(int number, int standard) {
        return number > standard;
    }
}
