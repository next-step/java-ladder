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
        int sizeOfUserGroup = userGroup.getUserGroup().size();
        LadderFactory ladderFactory = new LadderFactory(maxHeight, sizeOfUserGroup);

        GameResult result = new GameResult(userReward, sizeOfUserGroup);
        ResultView.printLadder(ladderFactory.getLadder(), userGroup, result);

        String request = InputView.requestResult();
        result.run(ladderFactory.getLadder(), userGroup.getUserGroup());
        ResultView.showResult(request, result);
    }
}
