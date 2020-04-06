package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String userValues = inputView.getUsers();
        String ladderResult = inputView.getLadderResult();
        String ladderHeight = inputView.getLadderHeight();

        LadderGame ladderGame = new LadderGame(userValues, ladderHeight, ladderResult);

        OutputView.resultPrint(ladderGame);

        String userName = inputView.getResultUserName();

        OutputView.gameResultPrint(ladderGame, userName);
    }
}
