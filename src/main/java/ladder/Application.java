package ladder;

import ladder.view.InputView;

public class Application {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        String names = InputView.inputName();
        int height = InputView.inputLadderHeight();
        String result = InputView.inputResult();
        ladderController.execute(names, height, result);

    }
}