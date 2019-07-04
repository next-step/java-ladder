package nextstep.controller;


import nextstep.domain.LadderGame;
import nextstep.view.*;

public class LadderGameMain {
    public static void main(String[] args) {
        String userNames = Inputview.inputUserName();
        String userReward = Inputview.inputUserReward();
        int maxHeight = Inputview.inputLadderMaxHeight();

        LadderGame ladderGame = new LadderGame(userNames, userReward, maxHeight);
        ladderGame.makeLadderMap(maxHeight);
        ResultView.printLadder(ladderGame);

        String request = Inputview.requestResult();
        ladderGame.startLadderGame();
        ResultView.showResult(request, ladderGame);

    }
}
