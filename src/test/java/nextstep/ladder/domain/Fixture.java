package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.StepGenerateStrategy;

public class Fixture {
    public static final StepGenerateStrategy ALWAYS_GENERATE_STRATEGY = () -> true;
    public static final StepGenerateStrategy NEVER_GENERATE_STRATEGY = () -> false;

    private Fixture() {}

}
