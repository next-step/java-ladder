package nextstep.ladder.controller;

import java.util.function.Supplier;

public class LadderParameterHandler {
    private LadderParameterHandler() {}

    static <T> T parseArgumentResolver(Supplier<T> method) {
        try {
            return method.get();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }
    }
}
