package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.Users;
import nextstep.ladder.engine.LadderCreator;
import nextstep.ladder.factory.LadderFactoryBean;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    private static InputView inputView = InputView.getInputView();
    private static ResultView resultView = ResultView.getResultView();

    public static void main(String[] args) {
        Users users = inputView.enterUserNames();
        Results results = inputView.enterResults();
        int ladderHeight = inputView.enterLadderHeight();

        LadderCreator ladderCreator = LadderFactoryBean.createLadderFactory(users.getCountOfPerson(),
                                                                            ladderHeight);
        List<LadderLine> ladderLines = ladderCreator.create().getLadder();
        LadderGame ladderGame = new LadderGame(users, results, ladderLines);

        resultView.printLadder(ladderGame);
        ladderGame.generateResultsForAllPlayers();
        resultView.repeatPrintPlayResult(users);
    }
}
