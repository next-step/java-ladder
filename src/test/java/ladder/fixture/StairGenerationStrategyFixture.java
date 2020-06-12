package ladder.fixture;

import ladder.domain.ladder.strategy.StairGenerationStrategy;

public class StairGenerationStrategyFixture {

    public static final StairGenerationStrategy TRUE_STRATEGY = () -> true;
    public static final StairGenerationStrategy FALSE_STRATEGY = () -> false;
}
