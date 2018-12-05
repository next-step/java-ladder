package ladder.domain;

import ladder.strategy.Difficulty;

public class LadderOption {

    private Difficulty difficulty;

    private LadderOption(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public static LadderOption create(int height) {
        Difficulty difficulty = Difficulty.findByHeight(height);
        return new LadderOption(difficulty);
    }

    public static LadderOption create(String text) {
        Difficulty difficulty = Difficulty.findByText(text);
        return new LadderOption(difficulty);
    }

    public Difficulty difficulty() {
        return difficulty;
    }
}
