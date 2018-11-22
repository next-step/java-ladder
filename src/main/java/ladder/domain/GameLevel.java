package ladder.domain;

public enum GameLevel {
    HIGH("상", 20, 90),
    MEDIUM("중", 10, 70),
    LOW("하", 5, 50);

    private final String level;
    private final int lineHeight;
    private final int drawingRate;

    GameLevel(String level, int lineHeight, int drawingRate) {
        this.level = level;
        this.lineHeight = lineHeight;
        this.drawingRate = drawingRate;
    }

    public int getLineHeight() {
        return lineHeight;
    }

    public int getDrawingRate() {
        return drawingRate;
    }

    public static GameLevel of(String level) {
        for (GameLevel gameLevel : GameLevel.values()) {
            if (gameLevel.level.equals(level)) {
                return gameLevel;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 게임난이도입니다.");
    }
}
