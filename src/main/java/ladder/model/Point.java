package ladder.model;

public class Point {

    private int index;

    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public static Point createForFirstLine(int index, GenerationStrategy generationStrategy) {
        return Point.of(index, Direction.of(false, generationStrategy.generate()));
    }

    public static Point createForLastLine(int index, Point prevPoint) {
        return Point.of(index, Direction.of(prevPoint.isRight(), false));
    }

    public static Point createComparingPrevPoint(int index, Point prevPoint, GenerationStrategy generationStrategy) {
        if (prevPoint.isRight()) {
            return Point.of(index, Direction.of(true, false));
        }
        return Point.of(index, Direction.of(false, generationStrategy.generate()));
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
