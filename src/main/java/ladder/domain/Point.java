package ladder.domain;

import ladder.dto.response.PointDto;

class Point {
    private final int index;
    private final Direction direction;

    Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    int move() {
        return index + direction.getMove();
    }

    private boolean isLeft() {
        return direction == Direction.LEFT;
    }

    PointDto getPointDto() {
        return new PointDto(isLeft());
    }
}
