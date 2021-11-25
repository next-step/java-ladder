package nextstep.ladder.utils;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static nextstep.ladder.utils.Validator.checkNotNull;

public class Parser {

    private static final Pattern delimiterPattern = Pattern.compile(",");

    private Parser() {
    }

    public static List<String> split(String string) {
        checkNotNull(string);

        String[] strings = delimiterPattern.split(string);
        return stream(strings).map(String::trim)
                .collect(Collectors.toList());
    }

}
