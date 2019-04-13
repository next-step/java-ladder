package ladder.domain;

import lombok.ToString;

@ToString
public enum Level {
    HIGH("상", 0.8, 20),
    MIDDLE("중", 0.5, 10),
    LOW("하", 0.2, 5);

    private String level;
    private double seed;
    private int lineSize;

    Level(String level, double seed, int lineSize) {
        this.level = level;
        this.seed = seed;
        this.lineSize = lineSize;
    }

    public static Level findLevel(String searchLevel) {
        for (Level value : Level.values()) {
            if(value.level.equals(searchLevel)) {
                return value;
            }
        }
        throw new IllegalArgumentException("잘못 입력했지?!");
    }

    public int getLineSize() {
        return lineSize;
    }

    public double getSeed() {
        return seed;
    }
}
