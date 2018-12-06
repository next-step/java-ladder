package domain.level;

public enum HeightLevel {
    EASY(5), NORMAL(10), HARD(20);

    private final int height;

    HeightLevel(int height) {
        this.height = height;
    }

    public int value() {
        return height;
    }
}
