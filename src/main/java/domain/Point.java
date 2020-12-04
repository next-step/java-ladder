package domain;

public class Point {
    private final Position position;
    private final Direction direction;

    private Point(final Position position, final Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point of(final Position position, final Direction direction) {
        return new Point(position, direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public Position next() {
        if(direction.isRight()) {
            return position.plus();
        }

        if(direction.isLeft()) {
            return position.minus();
        }

        return position;
    }

    public boolean isHeadingRight() {
        return direction.isRight();
    }
}
