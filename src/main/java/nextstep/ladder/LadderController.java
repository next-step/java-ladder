package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    private static InputView inputView = InputView.getInputView();
    private static ResultView resultView = ResultView.getResultView();

    public static void main(String[] args) {
        Users users = inputView.enterUserNames();
        Results results = inputView.enterResults();
        int ladderHeight = inputView.enterLadderHeight();

        LadderGame ladderGame = new LadderGame(users, results, ladderHeight);

        resultView.printLadder(ladderGame);
        users.generateResultsForAllPlayers(ladderGame);
        resultView.repeatPrintPlayResult(users);
    }
}
