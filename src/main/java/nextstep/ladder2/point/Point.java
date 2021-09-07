package nextstep.ladder2.point;

public class Point {
    public static final Point INVALID_POINT = new Point(Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
    private final int MAX_INDEX;
    private final int MIN_INDEX = 0;
    private int index;

    public Point(int index, int MAX_INDEX) {
        this.MAX_INDEX = MAX_INDEX;
        validation(index);
        this.index = index;
    }

    private void validation(int index) {
        if (index < 0 || index > MAX_INDEX) {
            throw new IllegalArgumentException("유효하지 않는 인덱스 입니다.");
        }
    }

    public int index() {
        return index;
    }

    public Point right() {
        if (this.index < MAX_INDEX) {
            return new Point(this.index + 1, MAX_INDEX);
        }
        return INVALID_POINT;
    }

    public Point left() {
        if (this.index > 0) {
            return new Point(this.index - 1, MAX_INDEX);
        }
        return INVALID_POINT;
    }

}
