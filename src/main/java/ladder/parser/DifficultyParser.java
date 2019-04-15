package ladder.parser;

import ladder.domain.ladder.Difficulty;

public class DifficultyParser {
    private static final String HARD = "상";
    private static final String NORMAL = "중";
    private static final String EASY = "하";

    private DifficultyParser() {
    }

    public static Difficulty parseDifficulty(String difficulty) {
        if (HARD.equals(difficulty)) {
            return Difficulty.HARD;
        }

        if (NORMAL.equals(difficulty)) {
            return Difficulty.HARD;
        }

        if (EASY.equals(difficulty)) {
            return Difficulty.HARD;
        }

        throw new IllegalArgumentException(String.format("Difficulty must be the one of %s, %s, %s", HARD, NORMAL, EASY));
    }
}
