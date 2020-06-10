package step3;

import step3.domain.LadderGame;
import step3.view.InputView;

public class MainApplication {

    public static void main(String[] args) {

        LadderGame ladderGame = new LadderGame();

        // input player
        ladderGame.setPlayerList(InputView.inputPlayerName());

        // ladders setting
        ladderGame.setLaddersHeight(InputView.inputLadderHeight());

        // draw ladders
        ladderGame.outputView();

    }


}
