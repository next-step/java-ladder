package nextstep.ladder.domain;

public enum PointType {
    LEFT(-1, true, false),
    RIGHT(1, false, true),
    NONE(0, false, false);


    private final int position;
    private final boolean left;
    private final boolean right;

    PointType(int position, boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("Point 는 양쪽이 true 일 수 없습니다.");
        }

        this.position = position;
        this.left = left;
        this.right = right;
    }

    public PointType afterPointType(boolean right) {
        return findPointType(this.right, right);
    }

    public static PointType findPointType(boolean left, boolean right) {
        if (left) {
            return PointType.LEFT;
        }

        if (right) {
            return PointType.RIGHT;
        }

        return PointType.NONE;
    }

    public Position move(Position currentPosition) {
        return currentPosition.move(this.position);
    }

    public boolean isRight() {
        return this.right;
    }
}
