package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.concrete.NormalLadderCreateStrategy;
import nextstep.ladder.domain.concrete.RandomLineCreateStrategy;
import nextstep.ladder.domain.strategy.LadderCreateStrategy;
import nextstep.ladder.domain.strategy.LineCreateStrategy;

public class LadderFactoryBean {
    public static LadderCreateStrategy createLadderFactory() {
        LineCreateStrategy lineCreateStrategy = new RandomLineCreateStrategy();
        return new NormalLadderCreateStrategy(lineCreateStrategy);
    }
}
