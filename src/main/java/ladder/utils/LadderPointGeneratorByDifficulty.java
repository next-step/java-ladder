package ladder.utils;

import ladder.domain.DifficultyType;

import java.util.Random;

public class LadderPointGeneratorByDifficulty implements PointGenerator {
    private static final int HUNDRED = 100;
    private int percentage;

    public LadderPointGeneratorByDifficulty(String difficulty) {
        this.percentage = DifficultyType.of(difficulty).percentageByDifficultyType();
    }

    @Override
    public boolean generatePoint() {
        if(new Random().nextInt(HUNDRED) <= this.percentage)
            return true;

        return false;
    }
}
