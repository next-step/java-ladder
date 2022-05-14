package nextstep.ladder.generator;

import nextstep.ladder.util.RandomRange;

public class RandomProductionGenerator implements PositionGenerator {
    private static final int RANDOM_VALUE_LINE_PRODUCTION = 4;

    @Override
    public boolean decideLineProduction() {
        return RandomRange.getRandomValue() >= RANDOM_VALUE_LINE_PRODUCTION;
    }
}
