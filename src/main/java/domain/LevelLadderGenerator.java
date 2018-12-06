package domain;

public class LevelLadderGenerator implements LineStrategy {
    private Difficulty difficulty;

    private LevelLadderGenerator(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public static LevelLadderGenerator from(Difficulty difficulty) {
        return new LevelLadderGenerator(difficulty);
    }

    @Override
    public boolean generate() {
        return difficulty.generatePoint();
    }
}
