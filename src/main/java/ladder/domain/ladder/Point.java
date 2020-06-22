package ladder.domain.ladder;

public class Point {
    private final boolean before;
    private final boolean after;

    private Point(boolean before, boolean after) {
        isNotBothTrue(before, after);
        this.before = before;
        this.after = after;
    }

    private void isNotBothTrue(boolean before, boolean after) {
        if (before && after) {
            throw new IllegalArgumentException("Point 전/후로 가로 라인이 존재할 수 없습니다.");
        }
    }

    public static Point of(boolean before, boolean after) {
        return new Point(before, after);
    }
}
