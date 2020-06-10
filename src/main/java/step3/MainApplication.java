package step3;

import step3.domain.LadderGame;
import step3.view.InputView;

public class MainApplication {

    public static void main(String[] args) {
        // input player
        String[] playerNames = InputView.inputPlayerName();
        // ladders setting
        int laddersHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = LadderGame.of(playerNames, laddersHeight);
        // draw ladders
        ladderGame.outputView();
    }

}
