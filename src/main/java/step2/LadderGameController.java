package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderGameController {
    public void start() {
        GameUsers gameUsers = new GameUsers(InputView.readUserNames());
        Ladder ladder = new Ladder(InputView.readLadderHeight(), gameUsers.getUserCount());
        BridgeBuildStrategy bridgeBuildStrategy = () -> Math.random() < 0.5;
        ladder.buildBridges(bridgeBuildStrategy);
//        LadderGenerator ladderGenerator = new LadderGenerator(new RandomBridgeBuildStrategy());
//        Ladder result = ladderGenerator.buildBridges(baseLadder);
        ResultView.displayLadder(gameUsers, ladder);
    }
}
