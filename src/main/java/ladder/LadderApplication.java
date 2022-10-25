package ladder;

import ladder.controller.LadderController;
import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {

        Names names = new Names(InputView.inputCandidateNames());
        Integer maxHeight = InputView.inputMaxLadderHeight();
        LadderController controller = new LadderController(names, maxHeight);

        ResultView.printResult(controller.getNames(), controller.getLadder());
    }
}
