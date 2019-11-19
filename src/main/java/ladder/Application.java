package ladder;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.InputView;

public class Application {

    private static final String END_KEY = "all";

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        String names = InputView.inputName();
        int height = InputView.inputLadderHeight();
        String result = InputView.inputResult();
        Ladder ladder = ladderController.execute(names, height, result);

        String wantResultPersonName = InputView.inputWantResult();
        for (; !wantResultPersonName.equals(END_KEY); ) {
            ladderController.displayResultOfAll(ladder, wantResultPersonName);
            wantResultPersonName = InputView.inputWantResult();
        }
        ladderController.displayResultAll(ladder);
    }
}