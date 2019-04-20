package domain;

import java.util.Arrays;

public enum Level {
    ADVANCED("상", 10, 8),
    INTERMEDIATE("중", 8, 5),
    BASIC("하", 5, 3);

    private String levelToText;
    private int height;
    private int percentage;

    Level(String levelToText, int height, int percentage) {
        this.levelToText = levelToText;
        this.height = height;
        this.percentage = percentage;
    }

    public static Level fineLevel(String levelToText) {
        return Arrays.stream(Level.values())
                .filter(level -> level.levelToText.equals(levelToText))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("난이도는 상중하 입니다."));
    }

    public int getHeight() {
        return height;
    }

    public int getPercentage() {
        return percentage;
    }

    public String getLevelToText() {
        return levelToText;
    }
}
