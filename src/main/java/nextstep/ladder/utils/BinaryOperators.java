package nextstep.ladder.utils;

import java.util.function.BinaryOperator;

public class BinaryOperators {
    public static <T> BinaryOperator<T> nope() {
        return (t, u) -> {
            throw new UnsupportedOperationException("병렬처리는 지원하지 않습니다.");
        };
    }
}
