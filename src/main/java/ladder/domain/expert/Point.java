package ladder.domain.expert;

import ladder.dto.PointDto;
import ladder.exception.ConsecutiveDirectionException;

public class Point {
    private final int position;
    private final Direction direction;

    public Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    int move() {
        return position + direction.getMove();
    }

    // FIXME: 이 로직을 Line 클래스로 옮길 방법은 없을까?
    void validate(Point consecutive) {
        if (direction == consecutive.direction && direction != Direction.DOWN) {
            throw ConsecutiveDirectionException.getInstance();
        }
    }

    boolean isLeft() {
        return direction == Direction.LEFT;
    }

    PointDto exportPointDto() {
        return new PointDto(isLeft());
    }
}
