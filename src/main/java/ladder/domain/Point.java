package ladder.domain;

import ladder.dto.PointDto;

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

    PointDto exportPointDto() {
        boolean isLeft = direction == Direction.LEFT;
        return new PointDto(isLeft);
    }
}
