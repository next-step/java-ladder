package ladder;

import ladder.controller.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class MainApplication {
    public static void main(String[] args) {
        ResultView resultView = LadderGame.start(new InputView());
        resultView.printLadder();
    }
}