package step3;

import step3.domain.LadderGame;
import step3.view.InputView;

public class MainApplication {

    public static void main(String[] args) {
        // input player
        String[] playerNames = InputView.inputPlayerName();
        // input winning prize
        String[] winningPrize = InputView.inputWinningPrize();
        // ladders setting
        int laddersHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = LadderGame.of(playerNames, winningPrize,laddersHeight);
        // draw ladders
        ladderGame.outputView();
        ladderGame.calculateWinningPrizeLine();
        ladderGame.outputResultView();

    }

}
