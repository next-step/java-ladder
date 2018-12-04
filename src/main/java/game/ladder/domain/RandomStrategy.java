package game.ladder.domain;

import java.util.Random;

public class RandomStrategy implements LevelSelectStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public Level select() {

        Level selectedLevel = Level.getLevel(RANDOM.nextInt(100) + 1);

        return selectedLevel;
    }
}
