package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGameController.play(new InputView(), new OutputView());
    }
}
