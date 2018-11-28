package domain.ladder;

import java.util.Arrays;
import java.util.Random;

public enum  LadderLevel {
    Beginning("상", new Random().nextInt(6) + 6),
    Intermediate("중", new Random().nextInt(4) + 4),
    Advanced("하", new Random().nextInt(2) + 2);

    private String level;
    private int random;

    LadderLevel(String level, int random) {
        this.level = level;
        this.random = random;
    }

    public static LadderLevel findLevel(String selectLevel){
        return Arrays.stream(values())
                .filter(level -> level.getLevel().equals(selectLevel))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getRandom() {
        return random;
    }

    public String getLevel() {
        return level;
    }
}
