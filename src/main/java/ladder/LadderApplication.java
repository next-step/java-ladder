package ladder;

import ladder.controller.LadderController;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        new LadderController(new InputView(), new ResultView()).run();
    }
}
