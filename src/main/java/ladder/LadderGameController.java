package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.LadderRewards;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {

    public static void main(String[] args) {
        String names = InputView.inputNames();
        LadderRewards ladderRewards = LadderRewards.of(InputView.inputRewards());
        int height = InputView.inputHeight();

        LadderGame ladderGame = LadderGame.of(names, height);

        ResultView.print(ladderGame, ladderRewards);

        LadderGameResult ladderGameResult = ladderGame.start(ladderRewards);
        String result = InputView.inputResult();
        ResultView.printResult(ladderGameResult.getNodeResults(result));
    }
}
