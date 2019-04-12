package ladder.application;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class ConsoleMain {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(InputView.inputUser(), InputView.inputLevel(), InputView.inputResults());
        OutputView.printLadder(ladderGame);

        LadderGameResult ladderGameResult = new LadderGameResult(ladderGame.play());
        OutputView.printResult(InputView.inputUserResult(), ladderGameResult);

    }
}
