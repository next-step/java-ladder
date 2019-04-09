package ladder.application;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

public class ConsoleMain {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(InputView.inputUser(), InputView.inputHeight());
        OutputView.printWinningResult(ladderGame);

    }
}
