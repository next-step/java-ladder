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

    public PointElement nextElement(boolean curr) {
        if (this == RIGHT && curr) {
            throw new IllegalArgumentException("PointElement 를 만들 수 없습니다.");
        }

        if (this == RIGHT) {
            return LEFT;
        }

        if (curr) {
            return RIGHT;
        }

        return PASS;
    }

    public PointElement lastElement() {
        if (this == RIGHT) {
            return LEFT;
        }

        return PASS;
    }

    public Position move(Position position) {
        return position.movedPosition(Position.of(factor));
    }
}
