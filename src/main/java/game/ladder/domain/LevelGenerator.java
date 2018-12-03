package game.ladder.domain;

public class LevelGenerator {

    private final LevelSelectStrategy strategy;

    public LevelGenerator(LevelSelectStrategy strategy) {
        this.strategy = strategy;
    }

    public Level generate() {
        return this.strategy.select();
    }
}
