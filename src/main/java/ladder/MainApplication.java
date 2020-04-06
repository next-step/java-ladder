package ladder;

import ladder.controller.LadderGame;
import ladder.view.InputView;

public class MainApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        LadderGame.start(inputView);
        LadderGame.getResult(inputView);
    }
}