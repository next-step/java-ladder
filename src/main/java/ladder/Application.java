package ladder;

import ladder.view.InputView;

public class Application {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        String person = InputView.inputName();
        int height = InputView.inputLadderHeight();
        ladderController.execute(person, height);
    }
}