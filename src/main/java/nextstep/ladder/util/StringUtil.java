package nextstep.ladder.util;

import nextstep.ladder.exception.IllegalSeparateException;

import java.util.regex.Pattern;

public class StringUtil {

    private static final Pattern patten = Pattern.compile(",");

    private StringUtil() {
    }

    public static String[] split(String names) {
        validate(names);
        return patten.split(names);
    }

    private static void validate(String names) {
        if (!patten.matcher(names).find()) {
            throw new IllegalSeparateException(names);
        }
    }
}
