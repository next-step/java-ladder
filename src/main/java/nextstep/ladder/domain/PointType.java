package nextstep.ladder.domain;

public enum PointType {
    LEFT(-1, false),
    RIGHT(1, true),
    NONE(0, false);


    private final int position;
    private final boolean right;

    PointType(int position, boolean right) {
        this.position = position;
        this.right = right;
    }

    public int move() {
        return this.position;
    }

    public boolean right() {
        return this.right;
    }
}
