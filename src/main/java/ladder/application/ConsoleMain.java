package ladder.application;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {
        List<String> inputPlayers = InputView.inputPlayers();
        String inputLevel = InputView.inputLevel();
        List<String> inputResults = InputView.inputResults();

        LadderGame ladderGame = new LadderGame(inputPlayers, inputLevel, inputResults);

        OutputView.printLadder(ladderGame);
        OutputView.printInputResults(inputResults);

        LadderGameResult ladderGameResult = new LadderGameResult(ladderGame.play());
        while (true) {
            String userResult = InputView.inputUserResult();
            OutputView.printResult(userResult, ladderGameResult);
            if(userResult.equals(OutputView.ALL)) {
                break;
            }
        }
    }
}
