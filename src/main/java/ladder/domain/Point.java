package ladder.domain;

public class Point {
    public static final int UNIT_HORIZONTAL_LINE_LENGTH = 1;

    private static final int FIRST_POSITION = 0;

    private final int position;
    private final Direction direction;

    public Point(int position, Direction direction) {
        validatePoint(position, direction);
        this.position = position;
        this.direction = direction;
    }

    public boolean isPreviousPoint(Point nextPoint) {
        return nextPoint.position - this.position == UNIT_HORIZONTAL_LINE_LENGTH;
    }

    public static Point first(boolean isRight) {
        return new Point(FIRST_POSITION, Direction.rightOrStraight(isRight));
    }

    public Point next(boolean isRight) {
        return new Point(position + UNIT_HORIZONTAL_LINE_LENGTH, direction.next(isRight));
    }

    public Point last() {
        return new Point(position + UNIT_HORIZONTAL_LINE_LENGTH, direction.last());
    }

    public boolean isLast(int width) {
        if (isRight()) {
            return false;
        }
        return this.position == width;
    }

    public boolean isFirstPosition() {
        return this.position == FIRST_POSITION;
    }

    public boolean isLastPosition(int width) {
        return this.position == width;
    }

    public boolean isRight() {
        return this.direction.equals(Direction.RIGHT);
    }

    public boolean isStraight() {
        return this.direction.equals(Direction.STRAIGHT);
    }

    public boolean isLeft() {
        return this.direction.equals(Direction.LEFT);
    }

    private void validatePoint(int position, Direction direction) {
        validatePosition(position);
        validateDirection(direction);
    }

    private void validatePosition(int position) {
        if (position < FIRST_POSITION) {
            throw new IllegalArgumentException(String.format("포인트 위치는 음수일 수 없습니다. 입려한 포인트 위치 : %d", position));
        }
    }

    private void validateDirection(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("방향 값은 null 일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (position != point.position) return false;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + direction.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
