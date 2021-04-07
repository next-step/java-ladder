package nextstep.ladder.controller;

import java.util.function.Supplier;

public final class LadderParameterHelper {
    private LadderParameterHelper() {}

    static <T> T parseArgumentResolver(Supplier<T> method) {
        try {
            return method.get();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }
}
