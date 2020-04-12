package nextstep.ladder;

import nextstep.ladder.domain.GameInfo;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Ladder2;
import nextstep.ladder.domain.PlayLadderGame;
import nextstep.ladder.domain.PlayLadderGame2;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.ResultView2;

public class LadderController {
    private static InputView inputView = InputView.getInputView();
    private static ResultView2 resultView = ResultView2.getResultView();
    private static PlayLadderGame2 playLadderGame = PlayLadderGame2.getPlayLadderGame();

    public static void main(String[] args) {
        Users users = inputView.enterUserNames();
        Results results = inputView.enterResults();
        GameInfo gameInfo = new GameInfo(users, results);
        int ladderHeight = inputView.enterLadderHeight();

        Ladder2 ladder = new Ladder2(users.getCountOfPerson(), ladderHeight);
        resultView.printLadder(gameInfo, ladder);
        Users resultsForAllPlayers = playLadderGame.generateResultsForAllPlayers(gameInfo, ladder);
        resultView.repeatPrintPlayResult(resultsForAllPlayers);
    }
}
