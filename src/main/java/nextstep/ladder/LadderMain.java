package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        new LadderController(new InputView(), new OutputView()).start();
    }
}
