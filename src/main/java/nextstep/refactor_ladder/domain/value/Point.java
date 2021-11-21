package nextstep.refactor_ladder.domain.value;

import nextstep.ladder.utils.Preconditions;
import nextstep.refactor_ladder.strategy.PointStrategy;

public class Point {
    private static final Integer PREVIOUS_POINT_INDEX = -1;
    private static final Integer NEXT_POINT_INDEX = 1;

    public final int index;
    public final Direction direction;

    private Point(int index, Direction direction) {
        Preconditions.checkNotNull(direction, "direction는 필수값입니다.");

        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return of(0, Direction.first(right));
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public Point next(PointStrategy pointStrategy) {
        return of(index + 1, direction.next(pointStrategy));
    }

    public int move() {
        if (direction.isLeft()) {
            return index + PREVIOUS_POINT_INDEX;
        }

        if (direction.isRight()) {
            return index + NEXT_POINT_INDEX;
        }

        return index;
    }
}
