package ladder.domain.strategy;

import java.util.Random;

public class RandomBuildLadder implements LadderGeneratorStrategy {

    @Override
    public Boolean isBuild() {
        return new Random().nextBoolean();
    }
}
