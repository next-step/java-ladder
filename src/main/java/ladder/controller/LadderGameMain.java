package ladder.controller;

import ladder.domain.GameResult;
import ladder.domain.LadderFactory;
import ladder.domain.UserGroup;
import ladder.view.Inputview;
import ladder.view.ResultView;

public class LadderGameMain {
    public static void main(String[] args) {
        String userNames = Inputview.inputUserName();
        String userReward = Inputview.inputUserReward();
        int maxHeight = Inputview.inputLadderMaxHeight();

        UserGroup userGroup = new UserGroup(userNames);
        LadderFactory ladderFactory = new LadderFactory(maxHeight, userGroup.getUserGroup().size());

        GameResult result = new GameResult(userReward, maxHeight);
        ResultView.printLadder(ladderFactory, userGroup, result);

        String request = Inputview.requestResult();
        result.run(ladderFactory, userGroup);
        ResultView.showResult(request, result);

    }
}
