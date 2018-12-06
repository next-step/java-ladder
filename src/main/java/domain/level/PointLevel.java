package domain.level;

public enum PointLevel {
    EASY(20), NORMAL(15), HARD(10);

    private final int bound;

    PointLevel(int bound) {
        this.bound = bound;
    }

    public int value() {
        return bound;
    }
}
