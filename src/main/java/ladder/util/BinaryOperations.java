package ladder.util;

import java.util.function.BinaryOperator;

public class BinaryOperations {

    public static <T> BinaryOperator<T> nope() {
        return (a, b) -> {
            throw new UnsupportedOperationException();
        };
    }
}
