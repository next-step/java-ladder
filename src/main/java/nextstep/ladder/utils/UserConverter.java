package nextstep.ladder.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UserConverter {

    private static final String DELIMITER = ",";

    private UserConverter() {
    }

    public static String convertToString(String[] users) {
        return Arrays.stream(users)
                .collect(Collectors.joining(DELIMITER));
    }
}
