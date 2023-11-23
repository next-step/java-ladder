package nextstep.step4.domain;

public class Point {
    private final boolean hasLeftRung;
    private final boolean hasRightRung;

    public Point(final boolean hasLeftRung, final boolean hasRightRung) {
        if (hasLeftRung && hasRightRung) {
            throw new IllegalArgumentException("양쪽에 사다리가 존재할 수 없습니다.");
        }
        this.hasLeftRung = hasLeftRung;
        this.hasRightRung = hasRightRung;
    }
}
