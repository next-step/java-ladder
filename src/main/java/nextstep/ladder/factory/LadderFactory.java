package nextstep.ladder.factory;

import nextstep.ladder.strategy.AlwaysAddLadderStrategy;
import nextstep.ladder.strategy.LadderStrategy;
import nextstep.ladder.strategy.RandomLadderStrategy;

public class LadderFactory {

    private LadderFactory() {
    }

    private static final LadderStrategy randomLadderStrategy = new RandomLadderStrategy();
    private static final LadderStrategy alwaysAddLadderStrategy = new AlwaysAddLadderStrategy();

    public static LadderStrategy randomLadderStrategy() {
        return randomLadderStrategy;
    }

    public static LadderStrategy alwaysAddLadderStrategy() {
        return alwaysAddLadderStrategy;
    }
}
