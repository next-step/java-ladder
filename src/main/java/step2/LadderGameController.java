package step2;

import step2.domain.GameUsers;
import step2.domain.Ladder;
import step2.domain.LadderGenerator;
import step2.domain.RandomBridgeBuildStrategy;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderGameController {

    public void start() {
        GameUsers gameUsers = new GameUsers(InputView.readUserNames());
        Ladder baseLadder = new Ladder(InputView.readLadderHeight(), gameUsers.getUserCount());
        LadderGenerator ladderGenerator = new LadderGenerator(new RandomBridgeBuildStrategy());
        Ladder result = ladderGenerator.buildBridges(baseLadder);
        ResultView.displayLadder(gameUsers, result);
    }
}
