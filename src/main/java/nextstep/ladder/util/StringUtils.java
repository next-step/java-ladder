package nextstep.ladder.util;

import java.util.Objects;

public class StringUtils {

    public static boolean isNullOrEmpty(String str) {

        return Objects.isNull(str) || str.isEmpty();
    }

}
