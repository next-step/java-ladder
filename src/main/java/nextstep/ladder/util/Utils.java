package nextstep.ladder.util;

import java.util.Collections;

public class Utils {
    public static String repeat(String target, int number) {
        return String.join("", Collections.nCopies(number, target));
    }
}
