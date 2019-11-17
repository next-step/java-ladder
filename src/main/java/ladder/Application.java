package ladder;

import ladder.domain.People;
import ladder.view.InputView;

public class Application {

    private static final String END_KEY = "all";

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        String names = InputView.inputName();
        int height = InputView.inputLadderHeight();
        String result = InputView.inputResult();
        People people = ladderController.execute(names, height, result);

        while (true) {
            String wantResult = InputView.inputWantResult();
            ladderController.displayResultOfAll(people, wantResult, result);
            if (wantResult.equals(END_KEY)) {
                break;
            }
        }
    }
}