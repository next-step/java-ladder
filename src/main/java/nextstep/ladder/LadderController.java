package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.UserResults;
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
        UserResults userResults = ladderGame.generateResultsForAllPlayers();
        ResultView.repeatPrintPlayResult(userResults);
    }
}
