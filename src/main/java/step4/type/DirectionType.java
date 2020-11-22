package step4.type;

import step4.domain.ladder.Point;

import java.util.function.UnaryOperator;

public enum DirectionType {
    DOWN(Point::downMove),
    LEFT(Point::leftMove),
    RIGHT(Point::rightMove);

    private final UnaryOperator<Point> move;

    DirectionType(UnaryOperator<Point> move) {
        this.move = move;
    }

    public static Point execute(DirectionType type, Point currentPoint) {
        return type.move.apply(currentPoint);
    }
}
