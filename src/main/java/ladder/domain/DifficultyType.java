package ladder.domain;

import java.util.Arrays;

public enum DifficultyType {
    HIGH("상", 20, 80),
    MID("중", 10, 50),
    LOW("하", 5, 30);

    private String difficulty;
    private int lineNum;
    private int percentage;

    DifficultyType(String difficulty, int lineNum, int percentage) {
        this.difficulty = difficulty;
        this.lineNum = lineNum;
        this.percentage = percentage;
    }

    public static DifficultyType of(String difficulty) {
        return Arrays.stream(DifficultyType.values())
                .filter(type -> type.difficulty.equals(difficulty))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int lineNumberByDifficultyType() {
        return this.lineNum;
    }

    public int percentageByDifficultyType() {
        return this.percentage;
    }

}
