package ladder;

import ladder.controller.LadderController;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {

    private static final InputView INPUT_VIEW = new InputView();
    private static final ResultView RESULT_VIEW = new ResultView();

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(INPUT_VIEW, RESULT_VIEW);
        ladderController.play();
    }
}
