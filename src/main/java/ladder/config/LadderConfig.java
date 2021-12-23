package ladder.config;

import ladder.generator.DefaultLadderGenerator;
import ladder.generator.Generator;
import ladder.strategy.DefaultPlayResult;
import ladder.strategy.LineStrategy;
import ladder.strategy.PlayResult;
import ladder.strategy.RandomLine;

public class LadderConfig {

    public Generator ladderGenerator() {
        return new DefaultLadderGenerator(lineStrategy());
    }

    public LineStrategy lineStrategy() {
        return new RandomLine();
    }

    public PlayResult playResult() {
        return new DefaultPlayResult();
    }

}
