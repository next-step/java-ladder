package ladder.application;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class ConsoleMain {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(InputView.inputUser(), InputView.inputHeight());
        LadderGameResult ladderGameResult = new LadderGameResult(InputView.inputResults());

        OutputView.printLadder(ladderGame);
        ladderGameResult.initPlayResults(ladderGame.play(ladderGameResult.getInputGameResults()));

        OutputView.printResult(InputView.inputUserResult(), ladderGameResult);

    }
}
