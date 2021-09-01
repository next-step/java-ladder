package nextstep.ladder;

import nextstep.ladder.controller.Game;
import nextstep.ladder.view.input.InputView;
import nextstep.ladder.view.output.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Game game = new Game(inputView, outputView);
        game.start();
    }

}
