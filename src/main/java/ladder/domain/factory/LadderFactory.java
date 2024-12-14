package ladder.domain.factory;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.LadderCreator;
import ladder.domain.engine.LineGenerator;
import ladder.domain.impl.LadderCreatorImpl;
import ladder.domain.impl.RandomLineGenerator;

public class LadderFactory {

    public static Ladder createLadder(int heightOfLadder, int numberOfPlayers) {
        LineGenerator lineGenerator = new RandomLineGenerator();
        LadderCreator ladderCreator = new LadderCreatorImpl(lineGenerator);
        return ladderCreator.create(heightOfLadder, numberOfPlayers);
    }

}
