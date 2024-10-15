package laddergame.domain;

import laddergame.ui.InputView;
import laddergame.ui.ResultView;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        LadderGame game = new LadderGame(inputView, resultView);
        game.run();
    }
}
