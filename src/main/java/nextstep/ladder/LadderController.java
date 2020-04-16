package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.LadderCreator;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.LadderLineCreator;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    private static InputView inputView = InputView.getInputView();
    private static ResultView resultView = ResultView.getResultView();
    private static LadderCreator ladderCreator = new LadderCreator(new LadderLineCreator());

    public static void main(String[] args) {
        Users users = inputView.enterUserNames();
        Results results = inputView.enterResults();
        int ladderHeight = inputView.enterLadderHeight();

        List<LadderLine> ladderLines = ladderCreator.create(users.getCountOfPerson(), ladderHeight);
        LadderGame ladderGame = new LadderGame(users, results, ladderLines);

        resultView.printLadder(ladderGame);
        users.generateResultsForAllPlayers(ladderGame);
        resultView.repeatPrintPlayResult(users);
    }
}
