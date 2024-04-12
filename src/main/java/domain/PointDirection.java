package domain;

import java.util.function.IntFunction;

public enum PointDirection {
    LEFT(value -> value - 1), RIGHT(value -> value + 1), NONE(value -> value);

    private final IntFunction<Integer> operator;

    PointDirection(IntFunction<Integer> operator) {
        this.operator = operator;
    }

    public int operate(int augend) {
        return operator.apply(augend);
    }
}
