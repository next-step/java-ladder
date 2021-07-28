package nextstep.ladder.domain;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.init.LadderSize;
import nextstep.ladder.domain.ladder.LadderColumn;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;

import java.util.Arrays;
import java.util.List;

public class Fixture {
    public static final StepGenerateStrategy ALWAYS_GENERATE_STRATEGY = () -> true;
    public static final StepGenerateStrategy NEVER_GENERATE_STRATEGY = () -> false;

    public static final LadderColumn RIGHT_STEP_LADDER_COLUMN = LadderColumn.initFirst(ALWAYS_GENERATE_STRATEGY);
    public static final LadderColumn NONE_STEP_LADDER_COLUMN = LadderColumn.initFirst(NEVER_GENERATE_STRATEGY);
    public static final LadderColumn LEFT_STEP_LADDER_COLUMN = LadderColumn.initFirst(ALWAYS_GENERATE_STRATEGY)
            .initNext(ALWAYS_GENERATE_STRATEGY);

    public static final LadderSize LADDER_SIZE_2_X_2 = LadderSize.of(2, 2);
    public static final LadderSize LADDER_SIZE_5_X_5 = LadderSize.of(5, 5);

    public static final LadderInitInfo LADDER_INIT_INFO_2_X_2 = LadderInitInfo.init(LADDER_SIZE_2_X_2, ALWAYS_GENERATE_STRATEGY);

    public static final List<String> TWO_PAYERS_NAMES = Arrays.asList("nokc", "cha");
    public static final Players TWO_PLAYERS = Players.init(TWO_PAYERS_NAMES);

    public static final List<String> TWO_RESULTS_VALUE = Arrays.asList("500", "꽝");
    public static final Results TWO_RESULTS = Results.init(TWO_RESULTS_VALUE);

    public static final LadderGameInitInfo LADDER_GAME_INIT_INFO_2_X_2 = LadderGameInitInfo.of(LADDER_INIT_INFO_2_X_2, TWO_PLAYERS);

    private Fixture() {}

}
