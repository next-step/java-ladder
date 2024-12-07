package ladder.domain.ns;

import ladder.domain.interfaces.enums.MoveStatus;
import ladder.domain.interfaces.Point;
import ladder.exception.PointException;

import java.util.Objects;

public class NsPoint implements Point {
    public static final String NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE = "사다리 라인을 연속해서 만들 수 없습니다.";
    private final boolean left;
    private final boolean right;

    private NsPoint(boolean left, boolean right) {
        if (left && right) {
            throw new PointException(NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE);
        }
        this.left = left;
        this.right = right;
    }

    public static NsPoint first(boolean right) {
        return new NsPoint(false, right);
    }

    @Override
    public NsPoint next(boolean right) {
        return new NsPoint(this.right, right);
    }

    @Override
    public NsPoint last() {
        return new NsPoint(this.right, false);
    }

    @Override
    public boolean getRight() {
        return right;
    }

    @Override
    public MoveStatus move() {
        if (!this.left && this.right) {
            return MoveStatus.RIGHT;
        }
        if (this.left && !this.right) {
            return MoveStatus.LEFT;
        }
        return MoveStatus.STOP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NsPoint point = (NsPoint) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Point{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}