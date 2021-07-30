package nextstep.ladder.domain;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.init.LadderSize;
import nextstep.ladder.domain.init.PlayersAndGifts;
import nextstep.ladder.domain.ladder.LadderColumn;
import nextstep.ladder.domain.ladder.Step;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.gift.Gifts;
import nextstep.ladder.domain.strategy.StepGenerateStrategy;
import nextstep.ladder.domain.strategy.StepGenerateStrategyTemp;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Fixture {
    public static final Random RETURN_TRUE_RANDOM = new Random() {
        @Override
        public boolean nextBoolean() {
            return true;
        }
    };

    public static final Random RETURN_FALSE_RANDOM = new Random() {
        @Override
        public boolean nextBoolean() {
            return false;
        }
    };

    public static final StepGenerateStrategyTemp ALWAYS_GENERATE_STRATEGY_TEMP = new StepGenerateStrategyTemp() {
        @Override
        public Step generateFirst() {
            return Step.RIGHT;
        }

        @Override
        public Step generateMiddle(Step prevStep) {
            if (prevStep.isRight()) {
                return Step.LEFT;
            }

            return Step.RIGHT;
        }

        @Override
        public Step generateLast(Step prevStep) {
            if (prevStep.isRight()) {
                return Step.LEFT;
            }

            return Step.NONE;
        }
    };

    public static final StepGenerateStrategyTemp NEVER_GENERATE_STRATEGY_TEMP = new StepGenerateStrategyTemp() {
        @Override
        public Step generateFirst() {
            return Step.NONE;
        }

        @Override
        public Step generateMiddle(Step prevStep) {
            if (prevStep.isRight()) {
                return Step.LEFT;
            }

            return Step.NONE;
        }

        @Override
        public Step generateLast(Step prevStep) {
            if (prevStep.isRight()) {
                return Step.LEFT;
            }

            return Step.NONE;
        }
    };

    public static final LadderColumn RIGHT_STEP_LADDER_COLUMN_TEMP = LadderColumn.initFirst2(ALWAYS_GENERATE_STRATEGY_TEMP);
    public static final LadderColumn NONE_STEP_LADDER_COLUMN_TEMP = LadderColumn.initFirst2(NEVER_GENERATE_STRATEGY_TEMP);
    public static final LadderColumn LEFT_STEP_LADDER_COLUMN_TEMP = LadderColumn.initFirst2(ALWAYS_GENERATE_STRATEGY_TEMP)
            .initNext2(ALWAYS_GENERATE_STRATEGY_TEMP);

    public static final LadderSize LADDER_SIZE_2_X_2 = LadderSize.of(2, 2);
    public static final LadderSize LADDER_SIZE_5_X_5 = LadderSize.of(5, 5);

    public static final LadderInitInfo LADDER_INIT_INFO_2_X_2_TEMP = LadderInitInfo.init(LADDER_SIZE_2_X_2, ALWAYS_GENERATE_STRATEGY_TEMP);
    public static final LadderInitInfo LADDER_INIT_INFO_5_X_5_TEMP = LadderInitInfo.init(LADDER_SIZE_5_X_5, ALWAYS_GENERATE_STRATEGY_TEMP);

    public static final List<String> TWO_PLAYERS_NAMES = Arrays.asList("nokc", "cha");
    public static final Players TWO_PLAYERS = Players.init(TWO_PLAYERS_NAMES);

    public static final List<String> TWO_GIFTS_VALUES = Arrays.asList("500", "꽝");
    public static final Gifts TWO_GIFTS = Gifts.init(TWO_GIFTS_VALUES);

    public static final PlayersAndGifts TWO_PLAYERS_AND_GIFTS = PlayersAndGifts.of(TWO_PLAYERS_NAMES, TWO_GIFTS_VALUES);
    public static final LadderGameInitInfo LADDER_GAME_INIT_INFO_2_X_2 = LadderGameInitInfo.of(TWO_PLAYERS_AND_GIFTS, LADDER_INIT_INFO_2_X_2_TEMP);

    private Fixture() {}

}
