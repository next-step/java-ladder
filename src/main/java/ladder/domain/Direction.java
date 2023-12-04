package ladder.domain;

import java.util.function.UnaryOperator;

public enum Direction {

        RIGHT(value -> value + 1),
        LEFT(value -> value - 1);

        private final UnaryOperator<Integer> expression;

        Direction(UnaryOperator<Integer> expression) {
                this.expression = expression;
        }

        public int apply(int value) {
                return expression.apply(value);
        }
}
