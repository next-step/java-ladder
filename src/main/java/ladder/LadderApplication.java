package ladder;

import ladder.controller.LadderController;
import ladder.factory.PointFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        LadderController controller = new LadderController(new InputView(), new ResultView(), new PointFactory());
        controller.run();
    }

}
