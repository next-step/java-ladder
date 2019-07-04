package ladder.controller;


import ladder.domain.LadderGame;
import ladder.view.Inputview;
import ladder.view.ResultView;

public class LadderGameMain {
    public static void main(String[] args) {
        String userNames = Inputview.inputUserName();
        String userReward = Inputview.inputUserReward();
        int maxHeight = Inputview.inputLadderMaxHeight();

        LadderGame ladderGame = new LadderGame(userNames, userReward, maxHeight);
        ResultView.printLadder(ladderGame);

        String request = Inputview.requestResult();
        ladderGame.startLadderGame();
        ResultView.showResult(request, ladderGame);

    }
}
