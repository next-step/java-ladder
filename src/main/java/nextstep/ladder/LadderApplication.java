package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView(), new ResultView());
        ladderController.execute();
    }
}
