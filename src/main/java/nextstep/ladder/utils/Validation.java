package nextstep.ladder.utils;

import nextstep.ladder.domain.exception.RequiredArgumentException;

import java.util.Collection;

public class Validation {

    private Validation() {
    }

    public static void checkNotNull(Object... objects) {
        for (Object object : objects) {
            checkNotNull(object);
        }
    }

    public static void checkNotNull(Object object) {
        if (object == null) {
            throw new RequiredArgumentException();
        }
    }

    public static void checkNotEmpty(Collection<?> objects) {
        if (objects == null || objects.isEmpty()) {
            throw new RequiredArgumentException();
        }
    }
}
