package ladderstep4.ladder.domain;

import ladder.util.RandomUtil;

public class Point {
    private final Position position;
    private final MoveDirection moveDirection;

    public Point(Position position, MoveDirection moveDirection) {
        this.position = position;
        this.moveDirection = moveDirection;
    }

    public static Point first() {
        return first(RandomUtil.randomBoolean());
    }

    public static Point first(boolean right) {
        return new Point(Position.ofFirst(), MoveDirection.first(right));
    }

    public Point next() {
        return new Point(position.next(), moveDirection.next());
    }

    public Point next(boolean right) {
        return new Point(position.next(), moveDirection.next(right));
    }

    public Point last() {
        return new Point(position.next(), moveDirection.last());
    }

    public Position move() {
        if (moveDirection.canMoveLeft()) {
            return position.before();
        }
        if (moveDirection.canMoveRight()) {
            return position.next();
        }
        return position;
    }

    public MoveDirection getMoveDirection() {
        return moveDirection;
    }
}
