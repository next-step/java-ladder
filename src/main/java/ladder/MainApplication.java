package ladder;

import ladder.controller.LadderGame;
import ladder.view.InputView;

public class MainApplication {
    public static void main(String[] args) {
        LadderGame.start(new InputView());
    }
}