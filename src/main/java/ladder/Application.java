package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String userValues = inputView.getUsers();
        String ladderHeight = inputView.getLadderHeight();

        LadderGame ladderGame = new LadderGame(userValues, ladderHeight);

        OutputView.resultPrint(ladderGame);
    }
}
