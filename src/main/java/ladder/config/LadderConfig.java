package ladder.config;

import ladder.domain.ladder.*;
import ladder.domain.user.LadderPlayers;
import ladder.generator.DefaultLadderGenerator;
import ladder.generator.DefaultLineGenerator;
import ladder.generator.LadderGenerator;
import ladder.generator.LineGenerator;
import ladder.strategy.LineStrategy;
import ladder.strategy.RandomLine;

public class LadderConfig {

    public LadderGenerator ladderGenerator(LadderPlayers players, LadderHeight height) {
        LineStrategy lineStrategy = new RandomLine();
        LineGenerator lineGenerator = new DefaultLineGenerator(lineStrategy);
        return new DefaultLadderGenerator(lineGenerator, players, height);
    }

}
