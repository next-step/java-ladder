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

    public static Point first() {
        return random(Position.initialize());
    }

    public Point next() {
        return new Point(direction.next(), position.next());
    }

    public Point nextLast() {
        return new Point(direction.nextLast(), position.next());
    }

    private static Point random(Position position) {
        return new Point(Direction.generate(), position);
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    public Player move(Player player) {
        return player.move(direction);
    }

    public Position move(Position position) {
        return position.move(direction);
    }

    @Override
    public String toString() {
        if (direction.isRight()) {
            return BEAM + CROSSABLE_STEP;
        }

        return BEAM + UN_CROSSABLE_STEP;
    }
}
