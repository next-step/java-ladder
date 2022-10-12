package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameApplication {
    public static void main(String[] args) {
        new LadderGameController(new InputView(), new ResultView()).run();
    }
}
