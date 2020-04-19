package nextstep.ladder;

import java.util.List;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.UserResult;
import nextstep.ladder.factory.LadderFactoryBean;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        String[] userNames = InputView.enterUserNames();
        String[] results = InputView.enterResults();
        int ladderHeight = InputView.enterLadderHeight();

        final LadderGame ladderGame = new LadderGame(userNames, results);
        ladderGame.startGame(LadderFactoryBean.createLadderFactory(userNames.length, ladderHeight));

        ResultView.printLadder(ladderGame);
        List<UserResult> userResults = ladderGame.generateResultsForAllPlayers();
        ResultView.repeatPrintPlayResult(userResults);
    }
}
