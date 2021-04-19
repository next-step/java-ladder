package nextstep.ladder.util;

import java.util.function.BinaryOperator;

public class BinaryOperators {

    private BinaryOperators() {}

    public static BinaryOperator<Integer> nope() {
        return (left, right) -> {
            throw new UnsupportedOperationException("병렬처리는 지원하지 않습니다");
        };
    }
}
