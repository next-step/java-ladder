package nextstep.step4.domain;

public class Point {
    private final boolean hasLeftRung;
    private final boolean hasRightRung;

    private Point(final boolean hasLeftRung, final boolean hasRightRung) {
        validatePoint(hasLeftRung, hasRightRung);

        this.hasLeftRung = hasLeftRung;
        this.hasRightRung = hasRightRung;
    }

    private void validatePoint(final boolean hasLeftRung, final boolean hasRightRung) {
        if (hasLeftRung && hasRightRung) {
            throw new IllegalArgumentException("양쪽에 사다리가 존재할 수 없습니다.");
        }
    }

    public Point next(boolean hasRightRung) {
        if (this.hasRightRung) {
            hasRightRung = false;
        }

        return new Point(this.hasRightRung, hasRightRung);
    }

    public Point last() {
        return new Point(this.hasRightRung, false);
    }

    public MoveDirection move() {
        if (hasLeftRung) {
            return MoveDirection.LEFT;
        }

        if (hasRightRung) {
            return MoveDirection.RIGHT;
        }

        return MoveDirection.NONE;
    }

    public static Point first(final boolean hasRightRung) {
        return new Point(false, hasRightRung);
    }
}
