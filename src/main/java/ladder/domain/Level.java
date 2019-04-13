package ladder.domain;

public enum Level {
    HIGH(20, 75),
    MIDDLE(10, 50),
    LOW(5, 25);

    private int height;
    private int weight;

    Level(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public static Level findLevel(String level) {
        level = level.toLowerCase();
        if(level.equals("high")) return HIGH;
        if(level.equals("middle")) return MIDDLE;
        if(level.equals("low")) return LOW;
        throw new IllegalArgumentException("난이도를 올바르게 입력해주세요.");
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
