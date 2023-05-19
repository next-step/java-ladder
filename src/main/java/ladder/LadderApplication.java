package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) throws Exception {
        Users users = InputView.inputUsers();
        LadderRewards ladderRewards = InputView.inputRewards(users.getUsersSize());
        LadderHeight ladderHeight = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(users, ladderHeight);
        ResultView.printLadder(ladderGame, ladderRewards);

        LadderGameResult ladderResult = ladderGame.play(ladderRewards);
        ResultView.showResult(ladderResult);
    }
}
