package net.chandol.ladder.v2.support;

import java.util.function.Predicate;

public class StringUtils {
    public static String toFixedLength(String value, int length) {
        return org.apache.commons.lang3.StringUtils.center(value, length);
    }

    public static void validateString(String value, int maxLength) {
        Predicate<String> isNullOrEmpty = n -> null == n || n.length() == 0;
        Predicate<String> isExceedLength = n -> n.length() > maxLength;

        if (isNullOrEmpty.test(value) || isExceedLength.test(value)) {
            throw new IllegalArgumentException("문자열 길이를 확인해주세요.");
        }
    }
}
