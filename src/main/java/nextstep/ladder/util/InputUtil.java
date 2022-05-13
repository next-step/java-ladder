package nextstep.ladder.util;

import java.util.List;

public final class InputUtil {

    private static final String splitValue = ",";

    private InputUtil() {
    }

    public static List<String> stringSplit(String value) {
        return List.of(value.split(splitValue));
    }

}
