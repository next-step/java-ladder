package ladder.model;

public class Point {

    private final Direction direction;

    private Point(Direction direction) {
        this.direction = direction;
    }

    public static Point of(Direction direction) {
        return new Point(direction);
    }

    public static Point createForFirstLine(GenerationStrategy generationStrategy) {
        return Point.of(Direction.of(false, generationStrategy.generate()));
    }

    public static Point createForLastLine(Point prevPoint) {
        return Point.of(Direction.of(prevPoint.isRight(), false));
    }

    public static Point createComparingPrevPoint(Point prevPoint, GenerationStrategy generationStrategy) {
        if (prevPoint.isRight()) {
            return Point.of(Direction.of(true, false));
        }
        return Point.of(Direction.of(false, generationStrategy.generate()));
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
