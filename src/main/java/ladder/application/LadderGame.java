package ladder.application;

import ladder.domain.*;
import ladder.infra.BasicLadderCreator;
import ladder.infra.RandomDirectionCreator;

public class LadderGame {
    public static Ladder createLadder(int playerCount, int height) {
        DirectionCreator directionCreator = new RandomDirectionCreator();
        LadderCreator ladderCreator = new BasicLadderCreator();
        return ladderCreator.create(playerCount, height, directionCreator);
    }

    public static LadderGameResults start(Ladder ladder, LadderGameInfo ladderGameInfo) {
        return new LadderGameResults(ladderGameInfo.match(ladder.exec(ladderGameInfo.userSize())));
    }
}
