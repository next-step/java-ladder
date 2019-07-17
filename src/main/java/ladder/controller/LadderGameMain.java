package ladder.controller;

import ladder.domain.GameResult;
import ladder.domain.LadderFactory;
import ladder.domain.UserGroup;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameMain {
    public static void main(String[] args) {
        String userNames = InputView.inputUserName();
        String userReward = InputView.inputUserReward();
        int maxHeight = InputView.inputLadderMaxHeight();

        UserGroup userGroup = new UserGroup(userNames);
        LadderFactory ladderFactory = new LadderFactory(maxHeight, userGroup.getUserGroup().size());

        GameResult result = new GameResult(userReward, userGroup.getUserGroup().size());
        ResultView.printLadder(ladderFactory.getLadder(), userGroup, result);

        String request = InputView.requestResult();
        result.run(ladderFactory.getLadder(), userGroup);
        ResultView.showResult(request, result);
    }
}
