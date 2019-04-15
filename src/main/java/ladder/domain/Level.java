package ladder.domain;

import java.util.Arrays;

public enum Level {
    HIGH("high", 20, 75),
    MIDDLE("middle", 10, 50),
    LOW("low", 5, 25);

    private String name;
    private int height;
    private int weight;

    Level(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public static Level findLevel(String level) {
        String levelName = level.toLowerCase();
        return Arrays.stream(Level.values())
                .filter(value -> value.name.equals(levelName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("난이도를 올바르게 입력해주세요."));
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
