package laddergame.controller;

import laddergame.domain.LadderLineGenerator;
import laddergame.domain.RandomLineGenerator;
import laddergame.ui.InputView;
import laddergame.ui.ResultView;

public class LadderGameController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LadderLineGenerator generator = new RandomLineGenerator();

        LadderGame game = new LadderGame(inputView, resultView, generator);
        game.run();
    }
}
