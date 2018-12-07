package domain;

public enum Level {

    HIGH("상", 20, 80),
    MIDDLE("중", 10, 40),
    LOW("하", 5, 20);

    public static final int MAXIMUM_WEIGHT = 100;

    private final String level;
    private final int height;
    private final int weight;

    Level(final String level, final int height, final int weight) {
        this.level = level;
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public static Level from(final String level) {
        for (Level value : Level.values()) {
            if (value.level.equals(level)) {
                return value;
            }
        }
        throw new IllegalArgumentException();
    }

}
