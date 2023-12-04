package nextstep.ladder.domain.lines;

import nextstep.ladder.domain.lines.position.Position;

public enum Direction {

    LEFT(-1), RIGHT(1), MIDDLE(0);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public Position move(Position position) {
        return position.moveByDirection(this.value);
    }
}
