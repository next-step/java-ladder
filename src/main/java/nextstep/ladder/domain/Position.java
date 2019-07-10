package nextstep.ladder.domain;

public class Position {
    private static final int MINIMUM_INDEX = 0;
    private static final int INCREASE_UNIT = 1;

    private final int index;
    private final int size;

    private Position(final int index, final int size) {
        if (index < MINIMUM_INDEX) {
            throw new IllegalArgumentException();
        }
        if (index >= size) {
            throw new IllegalArgumentException();
        }
        this.index = index;
        this.size = size;
    }

    public static Position first(final int size) {
        return new Position(0, size);
    }

    public Position increase() {
        return new Position(this.index + INCREASE_UNIT, size);
    }
}
