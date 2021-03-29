package laddarGame.domain;

import laddarGame.exception.WrongRangePositionException;

import java.util.Objects;

import static laddarGame.domain.Line.ONE;
import static laddarGame.domain.Line.ZERO;

public class Position {

    private final int position;

    public Position(int position) {
        if (position < ZERO) {
            throw new WrongRangePositionException("플레이어의 위치는 0에 이상이여야 합니다");
        }
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int position() {
        return position;
    }

    private Position rightMove() {
        return new Position(position + ONE);
    }

    private Position leftMove() {
        return new Position(position - ONE);
    }

    public int compare(Position position) {
        return this.position - position.position;
    }

    public Position move(Point prevPoint, Point curPoint, int maxPosition) {
        if (curPoint.toBoolean() && position < maxPosition) {
            return rightMove();
        }
        if (prevPoint.toBoolean() && !(position == ZERO)) {
            return leftMove();
        }
        return new Position(position);
    }
}
