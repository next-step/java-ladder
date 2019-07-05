package ladder.controller;

import ladder.domain.GameResult;
import ladder.domain.LadderGame;
import ladder.view.Inputview;
import ladder.view.ResultView;

public class LadderGameMain {
    public static void main(String[] args) {
        String userNames = Inputview.inputUserName();
        String userReward = Inputview.inputUserReward();
        int maxHeight = Inputview.inputLadderMaxHeight();

        LadderGame ladderGame = new LadderGame(userNames, maxHeight);
        ResultView.printLadder(ladderGame);

        String request = Inputview.requestResult();

        GameResult result = new GameResult(userReward, maxHeight);
        result.run(ladderGame);

        ResultView.showResult(request, ladderGame);

    }
}
