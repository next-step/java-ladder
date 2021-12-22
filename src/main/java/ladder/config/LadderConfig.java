package ladder.config;

import ladder.generator.DefaultLadderGenerator;
import ladder.generator.DefaultLineGenerator;
import ladder.generator.LadderGenerator;
import ladder.generator.LineGenerator;
import ladder.strategy.DefaultPlayResult;
import ladder.strategy.LineStrategy;
import ladder.strategy.PlayResult;
import ladder.strategy.RandomLine;

public class LadderConfig {

    public LadderGenerator ladderGenerator() {
        return new DefaultLadderGenerator(lineGenerator());
    }

    public LineGenerator lineGenerator() {
        return new DefaultLineGenerator(lineStrategy());
    }

    public LineStrategy lineStrategy() {
        return new RandomLine();
    }

    public PlayResult playResult() {
        return new DefaultPlayResult();
    }

}
