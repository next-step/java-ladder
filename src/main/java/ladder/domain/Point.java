package ladder.domain;

public class Point {
    public static final int UNIT_HORIZONTAL_LINE_LENGTH = 1;
    public static final int FIRST_POSITION = 0;

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
        return this.position == width - 1;
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

    public void validateFirstPoint() {
        if (this.isLeft()) {
            throw new IllegalArgumentException(String.format("첫번째 포인트는 왼쪽 방향일 수 없습니다. 현재 포인트 : %s", this));
        }
        if (!this.isFirstPosition()) {
            throw new IllegalArgumentException(String.format("첫번째 포인트는 position 이 0 이여야 합니다. 현재 포인트 : %s", this));
        }
    }

    public void validateMiddlePoint(Point previousPoint) {
        if ((previousPoint.isLeft() && this.isLeft())
                || previousPoint.isStraight() && this.isLeft()
                || previousPoint.isRight() && !this.isLeft()) {
            throw new IllegalArgumentException(String.format("이전 포인트와 현재 포인트의 방향이 잘못 되었습니다. 이전 포인트 : %s 현재 포인트 : %s", previousPoint, this));
        }
        if (!previousPoint.isPreviousPoint(this)) {
            throw new IllegalArgumentException(String.format("이전 포인트와 현재 포인트의 position 차이는 1 이여야 합니다. 입력받은 이전 포인트 : %s 현재 포인트 : %s", previousPoint, this));
        }
    }

    public void validateLastPoint(int width) {
        if (this.isRight()) {
            throw new IllegalArgumentException(String.format("마지막 포인트는 오른쪽 방향일 수 없습니다. 입력받은 포인트 : %s", this));
        }
        if (!this.isLastPosition(width)) {
            throw new IllegalArgumentException(String.format("마지막 포인트는 position 이 '라인 폭 - 1' (현재 라인 폭 - 1 : %d) 이여야 합니다. 입력받은 포인트 : %s", width - UNIT_HORIZONTAL_LINE_LENGTH, this));
        }
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
