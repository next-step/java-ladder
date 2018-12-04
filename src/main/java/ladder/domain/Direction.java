package ladder.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.Boolean.FALSE;

public enum Direction {

    LEFT                             (Boolean.TRUE , Boolean.FALSE),
    RIGHT                            (Boolean.FALSE, Boolean.TRUE ),
    DOWN                             (Boolean.FALSE, Boolean.FALSE);

    private boolean leftPoint;
    private boolean rightPoint;

    Direction(boolean leftPoint, boolean rightPoint) {
        if (leftPoint && rightPoint) {
            throw new IllegalStateException();
        }
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public static Direction of(boolean first, boolean second) {
        return Arrays.stream(Direction.values())
                .filter(
                        direction ->
                                direction.leftPoint == first &&
                                direction.rightPoint == second)
                .findAny()
                .orElseThrow(() -> new IllegalStateException());
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public static Direction last(boolean left) {
        return of(left, FALSE);
    }
}
