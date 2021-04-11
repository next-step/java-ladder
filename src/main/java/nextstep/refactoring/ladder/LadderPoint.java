package nextstep.refactoring.ladder;

import nextstep.refactoring.ladder.engine.Point;
import nextstep.refactoring.ladder.engine.Position;

public class LadderPoint implements Point {

    private final Position position;
    private final Direction direction;

    private LadderPoint(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static LadderPoint of(int position, Direction direction) {
        return new LadderPoint(Position.of(position), direction);
    }

    public static LadderPoint first() {
        return LadderPoint.of(0, Direction.first());
    }

    public LadderPoint last() {
        return LadderPoint.of(0, direction.last());
    }

    public LadderPoint next() {
        return new LadderPoint(position.getRight(), direction.next());
    }

    public LadderPoint next(Boolean right) {
        return new LadderPoint(position.getRight(), direction.next(right));
    }

    @Override
    public Position traverse() {
        if (direction.isLeft())  {
            return position.getLeft();
        }

        if (direction.isRight()) {
            return position.getRight();
        }

        return position;
    }
}
