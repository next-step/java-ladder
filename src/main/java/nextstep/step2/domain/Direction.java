package nextstep.step2.domain;

public enum Direction {
    LEFT(-1, true, false),
    DOWN(0, false, false),
    RIGHT(1, false, true);

    private final Integer value;
    private final boolean left;
    private final boolean right;

    Direction(Integer value, boolean left, boolean right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static int moveLeft(final int index) {
        return index + LEFT.value;
    }

    public static int moveDown(final int index) {
        return index;
    }

    public static int moveRight(final int index) {
        return index + RIGHT.value;
    }

}
