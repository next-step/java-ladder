package ladder.domain.point;

import static ladder.view.OutputView.BEAM;
import static ladder.view.OutputView.CROSSABLE_STEP;
import static ladder.view.OutputView.UN_CROSSABLE_STEP;

public class Point {
    private final Direction direction;

    public Point(Direction direction) {
        validate(direction);
        this.direction = direction;
    }

    private void validate(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("direction은 null 일 수 없습니다.");
        }
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public static Point first() {
        return random();
    }

    public Point next() {
        if (isRight()) {
            return left();
        }
        return random();
    }

    public Point nextLast() {
        if (isRight()) {
            return left();
        }
        return none();
    }

    private static Point left() {
        return new Point(Direction.LEFT);
    }

    private static Point random() {
        return new Point(Direction.generate());
    }

    private static Point none() {
        return new Point(Direction.NONE);
    }

    @Override
    public String toString() {
        if (direction.isRight()) {
            return BEAM + CROSSABLE_STEP;
        }

        return BEAM + UN_CROSSABLE_STEP;
    }
}
