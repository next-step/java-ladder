package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Column;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;

public class Fixture {
    public static final StepGenerateStrategy ALWAYS_GENERATE_STRATEGY = () -> true;
    public static final StepGenerateStrategy NEVER_GENERATE_STRATEGY = () -> false;

    public static final Column RIGHT_STEP_COLUMN = Column.init(ALWAYS_GENERATE_STRATEGY);
    public static final Column NONE_STEP_COLUMN = Column.init(NEVER_GENERATE_STRATEGY);
    public static final Column LEFT_STEP_COLUMN = Column.init(ALWAYS_GENERATE_STRATEGY)
            .initNext(ALWAYS_GENERATE_STRATEGY);

    private Fixture() {}

}
