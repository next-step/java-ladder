package ladder.domain;

import ladder.util.Random;

public enum Node {
    LEFT(-1), RIGHT(1), STAY(0);
    private int variation;

    Node(int variation) {
        this.variation = variation;
    }

    public static Node of(boolean left, boolean right) {
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

    public static Node first(boolean current) {
        return Node.of(false, current);
    }

    public static Node firstRandom() {
        return Node.of(false, Random.createBoolean());
    }

    public Node next(boolean current) {
        switch (this) {
            case RIGHT:
                return Node.of(true, current);
            default:
                return Node.of(false, current);
        }
    }

    public Node nextRandom() {
        if (this.variation == 1) {
            return LEFT;
        }
        return Node.of(false, Random.createBoolean());
    }

    public Node last() {
        return this.next(false);
    }

    public String toShow() {
        return (this.variation == 1 ? "-" : " ").repeat(5);
    }

    public int variation() {
        return this.variation;
    }
}
