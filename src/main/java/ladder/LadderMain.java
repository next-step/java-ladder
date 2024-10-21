package ladder;

import ladder.controller.InputView;
import ladder.controller.LadderController;
import ladder.controller.ResultView;

public class LadderMain {

    public static void main(String[] args) {
        LadderController controller = new LadderController(InputView.getInstance(), ResultView.getInstance());
        controller.play();
    }
}
