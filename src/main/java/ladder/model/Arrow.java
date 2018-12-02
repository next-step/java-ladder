package ladder.model;

public enum Arrow {
    LEFT(-1),
    BOTTOM(0),
    RIGHT(1);

    private int index;

    Arrow(int index) {
        this.index = index;
    }

    public static Arrow valueOf(boolean prev, boolean next) {
        if (prev && next) {
            throw new IllegalArgumentException();
        }

        if (isNext(prev, next)) {
            return RIGHT;
        }

        if (isPrev(prev, next)) {
            return LEFT;
        }

        return BOTTOM;
    }

    public int getIndex() {
        return index;
    }

    private static boolean isNext(boolean prev, boolean next) {
        return !prev && next;
    }

    private static boolean isPrev(boolean prev, boolean next) {
        return prev && !next;
    }
}
