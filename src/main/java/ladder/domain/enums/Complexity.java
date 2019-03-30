package ladder.domain.enums;

import java.util.Arrays;

public enum Complexity {
    EASY("하", 5),
    NORMAL("중", 10),
    HARD("상", 20);

    private final String difficulty;
    private final int ladderHeight;

    Complexity(String difficulty, int ladderHeight) {
        this.difficulty = difficulty;
        this.ladderHeight = ladderHeight;
    }

    public static Complexity of(String difficulty) {
        return Arrays.stream(Complexity.values())
            .filter(complexity -> complexity.difficulty.equals(difficulty))
            .findFirst().get();
    }

    public int height() {
        return this.ladderHeight;
    }
}
