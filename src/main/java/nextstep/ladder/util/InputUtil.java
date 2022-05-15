package nextstep.ladder.util;

import java.util.List;
import java.util.Random;

public final class InputUtil {

    private static final String splitValue = ",";
    private static final Random RANDOM = new Random();

    private InputUtil() {
    }

    public static List<String> stringSplit(String value) {
        return List.of(value.split(splitValue));
    }

    public static boolean randomBar(Boolean beforeStatus) {
        boolean result = RANDOM.nextBoolean();
        if (beforeStatus != null && beforeStatus) {
            return false;
        }
        return result;
    }
}
