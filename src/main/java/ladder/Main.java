package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        final String playerNames = InputView.inputPlayer();
        final int ladderHeight = InputView.inputLadderHeight();
        final LadderGame ladderGame = new LadderGame(playerNames, ladderHeight);
        ResultView.printResult(ladderGame);
    }
}
