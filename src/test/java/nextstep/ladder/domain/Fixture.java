package nextstep.ladder.domain;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.init.LadderSize;
import nextstep.ladder.domain.ladder.Column;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.Arrays;

public class Fixture {
    public static final StepGenerateStrategy ALWAYS_GENERATE_STRATEGY = () -> true;
    public static final StepGenerateStrategy NEVER_GENERATE_STRATEGY = () -> false;

    public static final Column RIGHT_STEP_COLUMN = Column.initFirst(ALWAYS_GENERATE_STRATEGY);
    public static final Column NONE_STEP_COLUMN = Column.initFirst(NEVER_GENERATE_STRATEGY);
    public static final Column LEFT_STEP_COLUMN = Column.initFirst(ALWAYS_GENERATE_STRATEGY)
            .initNext(ALWAYS_GENERATE_STRATEGY);

    public static final LadderSize LADDER_SIZE_2_X_2 = LadderSize.of(2, 2);
    public static final LadderSize LADDER_SIZE_5_X_5 = LadderSize.of(5, 5);

    public static final LadderInitInfo LADDER_INIT_INFO_2_X_2 = LadderInitInfo.init(LADDER_SIZE_2_X_2, ALWAYS_GENERATE_STRATEGY);

    public static final Players TWO_PLAYERS = Players.init(Arrays.asList("nok", "cha"));

    public static final LadderGameInitInfo LADDER_GAME_INIT_INFO_2_X_2 = LadderGameInitInfo.of(LADDER_INIT_INFO_2_X_2, TWO_PLAYERS);

    private Fixture() {}

}
