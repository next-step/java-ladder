package nextstep.ladder.domain;

public class Point {
    private final boolean hasRight;

    public Point(boolean hasRight) {
        this.hasRight = hasRight;
    }

    public boolean hasRight() {
        return hasRight;
    }

    public Point next(boolean nextHasRight) {
        if (this.hasRight) {
            return new Point(false); // 이미 선이 있으면 오른쪽에 또 둘 수 없음
        }
        return new Point(nextHasRight);
    }
}
