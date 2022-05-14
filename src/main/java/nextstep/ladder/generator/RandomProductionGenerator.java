package nextstep.ladder.generator;

import nextstep.ladder.util.RandomRange;

public class RandomProductionGenerator implements PositionGenerator {
    @Override
    public boolean decideLineProduction() {
        return RandomRange.getRandomValue();
    }
}
