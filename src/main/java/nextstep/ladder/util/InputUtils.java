package nextstep.ladder.util;

import java.util.Objects;

public class InputUtils {

    private static final String NON_NULL = "입력값은 null 일 수 없습니다";

    public static  <T> void requireNonNull(final T input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

}
