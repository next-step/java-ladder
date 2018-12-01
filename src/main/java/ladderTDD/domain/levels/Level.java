package ladderTDD.domain.levels;

import java.util.Arrays;

public enum Level {
    ADVANCED("상", 20, 1, 57),
    INTERMEDIATE("중", 10, 58, 85),
    BASIC("하", 5, 86, 99),
    NOTHING("무", 0, 0, 0);

    private String ladderLevel;
    private int ladderHeight;
    private int linePercentageFrom;
    private int linePercentageTo;

    Level(String ladderLevel, int ladderHeight, int from, int to) {
        this.ladderLevel = ladderLevel;
        this.ladderHeight = ladderHeight;
        this.linePercentageFrom = from;
        this.linePercentageTo = to;
    }

    public static Level valueByRandomvalue(int randomValue) {
        return Arrays.stream(Level.values())
                .filter(level -> level.containLevel(randomValue))
                .findAny()
                .orElse(NOTHING);
    }

    public static Level valueByHeight(String ladderHeight) {
        return Arrays.stream(Level.values())
                .filter(level -> level.isHeight(ladderHeight))
                .findAny()
                .orElse(NOTHING);
    }

    private boolean isHeight(String ladderHeight) {
        if (this.ladderLevel.equals(ladderHeight.trim())) {
            return true;
        }
        return false;
    }

    private boolean containLevel(int randomValue) {
        if (randomValue >= this.linePercentageFrom && randomValue <= this.linePercentageTo) {
            return true;
        }
        return false;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
