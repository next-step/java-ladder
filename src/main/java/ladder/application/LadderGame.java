package ladder.application;

import ladder.domain.*;
import ladder.infra.BasicLadderCreator;
import ladder.infra.RandomDirectionCreator;

import java.util.List;

public class LadderGame {
    public static Ladder createLadder(LadderInfo ladderInfo) {
        DirectionCreator directionCreator = new RandomDirectionCreator();
        LadderCreator ladderCreator = new BasicLadderCreator();
        return ladderCreator.create(ladderInfo, directionCreator);
    }

    public static LadderGameResults start(Ladder ladder, LadderGameInfo ladderGameInfo) {
        List<User> users = ladderGameInfo.getUsers();
        return new LadderGameResults(ladderGameInfo.match(ladder.exec(users.size())));
    }
}
