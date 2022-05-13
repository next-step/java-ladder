package ladder.domain.point;

public class Point {
    private final Position position;
    private final Direction direction;

    public Point(Position position, Direction direction) {
        validate(position, direction);
        this.position = position;
        this.direction = direction;
    }

    private void validate(Position position, Direction direction) {
        if (position == null) {
            throw new IllegalArgumentException("position은 null 일 수 없습니다.");
        }
        if (direction == null) {
            throw new IllegalArgumentException("direction은 null 일 수 없습니다.");
        }
    }
}
