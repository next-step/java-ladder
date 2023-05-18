package ladder.domain;


import ladder.strategy.MoveStratege;

public class Point {
    private static final int PREVIOUS_NUMBER = 1;
    private final Position position;
    private final Direction direction;

    private Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point init(MoveStratege moveStrategy) {
        return new Point(Position.firstPosition(), Direction.firstDirectionOfPoint(moveStrategy));
    }

    public int currentUserPosition() {
        return position.currentPosition();
    }
    public int currentPreviousUserPosition() {
        return position.currentPosition() - PREVIOUS_NUMBER;
    }

    public boolean canMoveNext() {
        return direction.canMoveNext();
    }

    public boolean canMovePrevious() {
        return direction.canMovePrevious();
    }

    public Point createNextPoint(MoveStratege moveStrategy) {
        return new Point(position.moveNext(), direction.nextDirectionOfPoint(moveStrategy));
    }

    public Point createLastPoint() {
        return new Point(position.moveNext(), direction.lastDirectionOfPoint());
    }

}
