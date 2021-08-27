package nextstep.ladder.util;

import java.util.Objects;

public class StringUtils {

    public static boolean isNullOrEmpty(String str) {

        if (Objects.isNull(str) || str.isEmpty()) {
            return true;
        }
        return false;
    }

}
