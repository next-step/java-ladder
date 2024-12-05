package nextstep.ladder.domain.laddergame.position;

import nextstep.ladder.domain.line.point.Point;

public class Position {
    private final int position;

    public Position(int position) {
        if (0 > position) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
        }

        this.position = position;
    }

    public Position move(Point point) {
        if (point.canMoveLeft()) {
            return new Position(position - 1);
        }

        if (point.canMoveRight()) {
            return new Position(position + 1);
        }

        return new Position(position);
    }

    public int getPosition() {
        return position;
    }
}
