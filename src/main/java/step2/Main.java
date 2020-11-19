package step2;

import step2.controller.LadderGameController;
import step2.view.LadderGameInputView;
import step2.view.LadderGameResultView;

public class Main {
    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController(new LadderGameInputView(), new LadderGameResultView());
        controller.play();
    }
}
