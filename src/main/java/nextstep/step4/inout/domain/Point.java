package nextstep.step4.inout.domain;

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

    public static Point first(final boolean hasRightRung) {
        return new Point(false, hasRightRung);
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

    public int move(int index) {
        if (hasLeftRung) {
            return index - 1;
        }

        if (hasRightRung) {
            return index + 1;
        }

        return index;
    }

    public boolean hasRightRung() {
        return hasRightRung;
    }
}
