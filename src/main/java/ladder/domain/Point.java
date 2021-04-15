package ladder.domain;

public class Point {

    private static final int FIRST_INDEX = 0;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        validate(index, direction);
        this.index = index;
        this.direction = direction;
    }

    private void validate(int index, Direction direction) {
        if (index < FIRST_INDEX) {
            throw new IllegalArgumentException("인덱스 값은 최소 " + FIRST_INDEX + " 이어야 합니다.");
        }
        if (direction == null) {
            throw new IllegalArgumentException("방향 정보를 입력해 주세요.");
        }
        if (index == FIRST_INDEX && direction.isLeft()) {
            throw new IllegalArgumentException("첫 번째 포인트는 좌측 선을 가질 수 없습니다.");
        }
    }

    public static Point first(boolean right) {
        return new Point(FIRST_INDEX, Direction.first(right));
    }

    public Point next(boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }
        if (direction.isRight()) {
            return index + 1;
        }
        return index;
    }

    public boolean hasRightLine() {
        return direction.isRight();
    }
}
