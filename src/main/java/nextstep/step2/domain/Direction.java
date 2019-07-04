package nextstep.step2.domain;

public enum  Direction {
    LEFT(-1),
    RIGHT(1);

    private final Integer value;

    Direction(Integer value) {
        this.value = value;
    }

    public static int moveLeft(final int index) {
        return index + LEFT.value;
    }

    public static int moveRight(final int index) {
        return index + RIGHT.value;
    }

}
