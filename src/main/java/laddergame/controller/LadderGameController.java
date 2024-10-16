package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderLineStatusGenerator;
import laddergame.domain.RandomLineStatusGenerator;
import laddergame.ui.InputView;
import laddergame.ui.ResultView;

public class LadderGameController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LadderLineStatusGenerator generator = new RandomLineStatusGenerator();

        LadderGame game = new LadderGame(inputView, resultView, generator);
        game.run();
    }
}
