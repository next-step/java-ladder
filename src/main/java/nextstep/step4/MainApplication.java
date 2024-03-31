package nextstep.step4;

import nextstep.step4.controller.LadderGameController;
import nextstep.step4.view.InputView;
import nextstep.step4.view.OutputView;

public class MainApplication {

    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController(new InputView(), new OutputView());
        controller.run();
    }
}
