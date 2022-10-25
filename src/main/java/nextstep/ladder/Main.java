package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView(), new OutputView());
        ladderController.startGame();
    }
}
