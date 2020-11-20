package step3;

import step3.controller.LadderGameController;
import step3.view.LadderGameInputView;
import step3.view.LadderGameResultView;

public class Main {
    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController(new LadderGameInputView(), new LadderGameResultView());
        controller.play();
    }
}
