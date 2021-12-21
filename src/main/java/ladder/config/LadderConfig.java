package ladder.config;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.generator.DefaultLadderGenerator;
import ladder.generator.DefaultLineGenerator;
import ladder.generator.LadderGenerator;
import ladder.generator.LineGenerator;
import ladder.strategy.DefaultPlayResult;
import ladder.strategy.LineStrategy;
import ladder.strategy.PlayResult;
import ladder.strategy.RandomLine;

public class LadderConfig {

    public LadderGenerator ladderGenerator(LadderHeight height) {
        return new DefaultLadderGenerator(lineGenerator(), height);
    }

    public LineGenerator lineGenerator() {
        return new DefaultLineGenerator(lineStrategy());
    }

    public LineStrategy lineStrategy() {
        return new RandomLine();
    }

    public PlayResult playResult(Ladder ladder) {
        return new DefaultPlayResult(ladder);
    }

}
