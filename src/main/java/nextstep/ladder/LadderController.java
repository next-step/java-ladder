package nextstep.ladder;

import nextstep.ladder.domain.GameInfo;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PlayLadderGame;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    private static InputView inputView = InputView.getInputView();
    private static ResultView resultView = ResultView.getResultView();
    private static PlayLadderGame playLadderGame = PlayLadderGame.getPlayLadderGame();

    public static void main(String[] args) {
        Users users = inputView.enterUserNames();
        Results results = inputView.enterResults();
        GameInfo gameInfo = new GameInfo(users, results);
        int ladderHeight = inputView.enterLadderHeight();

        Ladder ladder = new Ladder(users.getCountOfPerson(), ladderHeight);
        resultView.printLadder(gameInfo, ladder);
        Users resultsForAllPlayers = playLadderGame.generateResultsForAllPlayers(gameInfo, ladder);

        String userName = inputView.enterResultUser(users);
        resultView.printPlayResult(resultsForAllPlayers, userName);

        String all = inputView.enterResultUser(users);
        resultView.printPlayResult(resultsForAllPlayers, all);
    }
}
