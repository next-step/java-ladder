package domain.level;

public enum PointLevel {
    EASY(20), NORMAL(15), HARD(10);

    private final int height;

    PointLevel(int height) {
        this.height = height;
    }

    public int value() {
        return height;
    }
}
