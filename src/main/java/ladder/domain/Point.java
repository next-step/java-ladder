package ladder.domain;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Point(boolean isLeft, boolean isRight) {
        this.direction = new Direction(isLeft, isRight);
    }

    public static Point of(Direction direction) {
        return new Point(direction);
    }

    public static Point createPointForFirstLine(DirectionGenerateStrategy generateStrategy) {
        return Point.of(new Direction(false, generateStrategy.generate()));
    }

    public static Point createPointForLastLine(Point prevPoint) {
        return Point.of(new Direction(prevPoint.isRight(), false));
    }

    public static Point createPointForMiddleLines(Point prevPoint, DirectionGenerateStrategy generateStrategy) {
        if (prevPoint.isRight()) {
            return Point.of(new Direction(true, false));
        }
        return Point.of(new Direction(false, generateStrategy.generate()));
    }

    public boolean isRight() {
        return this.direction.isRight();
    }

    public boolean isLeft() {
        return this.direction.isLeft();
    }

    public int move(int index) {
        return this.direction.move(index);
    }
}
