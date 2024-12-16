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
        return new Position(position + MoveDirection.move(point.canMoveLeft(), point.canMoveRight()));
    }

    public int getPosition() {
        return position;
    }
}
