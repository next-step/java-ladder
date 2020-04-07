package nextstep.ladder;

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
        int ladderHeight = inputView.enterLadderHeight();

        int countOfPerson = users.getUsers().size();
        Ladder ladder = new Ladder(countOfPerson, ladderHeight);

        resultView.printLadder(users, ladder, results);
        Users resultsForAllPlayers = playLadderGame.generateResultsForAllPlayers(users, ladder, results);

        String userName = inputView.enterResultUser(users);
        resultView.printPlayResult(resultsForAllPlayers, userName);

        String all = inputView.enterResultUser(users);
        resultView.printPlayResult(resultsForAllPlayers, all);
    }
}
