package ladder;

import ladder.controller.LadderController;
import ladder.factory.RowFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        LadderController controller = new LadderController(InputView.inputView(), ResultView.resultView(), new RowFactory());
        controller.run();
    }

}
