package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;
import nextstep.ladder.view.input.InputView;
import nextstep.ladder.view.output.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LadderGame ladderGame = new LadderGame(inputView, outputView);
        ladderGame.start();
    }

}
