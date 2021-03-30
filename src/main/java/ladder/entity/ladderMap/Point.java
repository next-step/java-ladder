package ladder.entity.ladderMap;

import ladder.entity.moveStrategy.MoveStrategy;
import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

import java.util.Objects;

public class Point {

    private int index;

    public Point(int index) {
        this.index = verifiedIndex(index);
    }

    private int verifiedIndex(int index) {
        if (index < 0) {
            throw new CustomException(ErrorCode.INVALID_POINT_INDEX);
        }
        return index;
    }

    public int index() {
        return this.index;
    }

    public Point move(MoveStrategy moveStrategy) {
        return new Point(this.index + moveStrategy.move().direction());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
