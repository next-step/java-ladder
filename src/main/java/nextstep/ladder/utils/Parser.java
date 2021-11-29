package nextstep.ladder.utils;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static nextstep.ladder.utils.Validator.checkNotNull;

public class Parser {

    private static final Pattern DELIMITER_PATTERN = Pattern.compile(",");

    private Parser() {
    }

    public static List<String> split(String string) {
        checkNotNull(string);

        String[] strings = DELIMITER_PATTERN.split(string);
        return stream(strings).map(String::trim)
                .collect(Collectors.toList());
    }

    public static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 가능합니다.");
        }
    }

}
