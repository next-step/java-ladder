package step4;

import step4.controller.LadderGameController;
import step4.view.LadderGameInputView;
import step4.view.LadderGameResultView;

public class Main {
    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController(new LadderGameInputView(), new LadderGameResultView());
        controller.play();
    }
}
