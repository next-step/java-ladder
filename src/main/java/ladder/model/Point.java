package ladder.model;

import ladder.exception.InvalidDirectionException;

public class Point {

    private final Direction direction;

    private Point(boolean isLeft, boolean isRight) {
        this.direction = Direction.of(isLeft, isRight);
    }

    public static Point of(boolean isLeft, boolean isRight) {
        return new Point(isLeft, isRight);
    }

    public static Point createForFirstLine(GenerationStrategy generationStrategy) {
        return Point.of(false, generationStrategy.generate());
    }

    public static Point createForLastLine(Point prevPoint) {
        return Point.of(prevPoint.isRight(), false);
    }

    public static Point createComparingPrevPoint(Point prevPoint, GenerationStrategy generationStrategy) {
        if (prevPoint.isRight()) {
            return Point.of(true, false);
        }
        return Point.of(false, generationStrategy.generate());
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public int move(int rowIndex) {
        return direction.move(rowIndex);
    }

}
