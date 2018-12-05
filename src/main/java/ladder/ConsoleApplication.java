package ladder;

import ladder.model.Ladder;
import ladder.model.LadderGame;

import static ladder.ui.console.InputView.inputLadderHeight;
import static ladder.ui.console.InputView.inputNames;
import static ladder.ui.console.InputView.inputReward;
import static ladder.ui.console.ResultView.ladderResult;

public class ConsoleApplication {
    public static void main(String[] args) {
        String names = inputNames();
        int height = inputLadderHeight();

        String reward = inputReward();

        LadderGame ladder = LadderGame.of(names, reward, height);
        ladderResult(ladder);
    }
}
