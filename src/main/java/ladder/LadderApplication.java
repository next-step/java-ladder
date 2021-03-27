package ladder;

import ladder.controller.LadderController;
import ladder.view.InputView;

public class LadderApplication {

    public static void main(String[] args) {
        new LadderController(new InputView()).run();
    }
}
