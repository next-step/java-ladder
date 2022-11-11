package ladder.controller;

import ladder.model.Names;
import ladder.view.InputView;

public class LadderController {

    public void run() {
        Names names = new Names(InputView.inputNames());
    }
}
