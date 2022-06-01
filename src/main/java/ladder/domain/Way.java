package ladder.domain;

import ladder.util.Random;

public enum Way {
    LEFT(-1), RIGHT(1), STAY(0);
    private int variation;

    Way(int variation) {
        this.variation = variation;
    }

    public static Way of(boolean left, boolean right) {
        validate(left, right);
        if (right) {
            return RIGHT;
        }
        if (left) {
            return LEFT;
        }
        return STAY;
    }

    private static void validate(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("left and right cannot be true consecutively.");
        }
    }

    protected static Way first(boolean current) {
        return Way.of(false, current);
    }

    public static Way firstRandom() {
        return Way.of(false, Random.createBoolean());
    }

    public Way next(boolean current) {
        switch (this) {
            case RIGHT:
                return Way.of(true, current);
            default:
                return Way.of(false, current);
        }
    }

    public Way nextRandom() {
        if (this.variation == 1) {
            return LEFT;
        }
        return Way.of(false, Random.createBoolean());
    }

    public Way last() {
        return this.next(false);
    }

    public String toShow() {
        return (this.variation == 1 ? "-" : " ").repeat(5);
    }

    public int variation() {
        return this.variation;
    }
}
