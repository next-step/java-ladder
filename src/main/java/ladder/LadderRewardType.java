package ladder;

import java.util.Random;

public enum LadderRewardType {
    MISS("꽝"),
    THIRD("3000"),
    SECOND("5000"),
    FIRST("10000");

    private final String name;

    private LadderRewardType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static LadderRewardType getRandomType() {
        Random random = new Random();
        int randomIndex = random.nextInt(values().length);
        return values()[randomIndex];
    }
}
