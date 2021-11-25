package nextstep.ladder.utils;

import java.util.Objects;

public class Validator {

    public static final String NOT_NULL_ERROR_MESSAGE = "필수 값이 없습니다.";

    private Validator() {
    }

    public static void checkNotNull(Object... object) {
        for (Object o : object) {
            checkNotNull(o);
        }
    }

    public static void checkNotNull(Object object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(NOT_NULL_ERROR_MESSAGE);
        }
    }
}
