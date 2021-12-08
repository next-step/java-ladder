package ladder;

/**
 *      기준
 * |-----|        < LEFT
 *       |     |  < PASS
 *       |-----|  < RIGHT
 */
public enum PointElement {
    LEFT(-1),
    PASS(0),
    RIGHT(1);

    private final int factor;

    PointElement(int factor) {
        this.factor = factor;
    }

    public static PointElement first(boolean curr) {
        if (curr) {
            return RIGHT;
        }
        return PASS;
    }

    public PointElement next(boolean curr) {
        if (this == RIGHT) {
            return LEFT;
        }

        if (curr) {
            return RIGHT;
        }

        return PASS;
    }

    public PointElement last() {
        if (this == RIGHT) {
            return LEFT;
        }

        return PASS;
    }

    public Position move(Position position) {
        return Position.of(position.value() + factor);
    }
}
