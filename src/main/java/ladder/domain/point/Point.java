package ladder.domain.point;

import ladder.domain.player.Player;

import static ladder.view.OutputView.BEAM;
import static ladder.view.OutputView.CROSSABLE_STEP;
import static ladder.view.OutputView.UN_CROSSABLE_STEP;

public class Point {
    private final Direction direction;
    private final Position position;

    public Point(Direction direction, Position position) {
        validate(direction, position);
        this.position = position;
        this.direction = direction;
    }

    private void validate(Direction direction, Position position) {
        if (direction == null) {
            throw new IllegalArgumentException("direction은 null 일 수 없습니다.");
        }

        if (position == null) {
            throw new IllegalArgumentException("position은 null 일 수 없습니다.");
        }
    }

    private boolean isRight() {
        return direction.isRight();
    }

    public static Point first() {
        return random(Position.initialize());
    }

    public Point next() {
        if (isRight()) {
            return left(position.move(Direction.RIGHT));
        }
        return random(position.move(Direction.RIGHT));
    }

    public Point nextLast() {
        if (isRight()) {
            return left(position.move(Direction.RIGHT));
        }
        return none(position.move(Direction.RIGHT));
    }

    private static Point left(Position position) {
        return new Point(Direction.LEFT, position);
    }

    private static Point random(Position position) {
        return new Point(Direction.generate(), position);
    }

    private static Point none(Position position) {
        return new Point(Direction.NONE, position);
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Player move(Player player) {
        return player.move(direction);
    }

    @Override
    public String toString() {
        if (direction.isRight()) {
            return BEAM + CROSSABLE_STEP;
        }

        return BEAM + UN_CROSSABLE_STEP;
    }
}
