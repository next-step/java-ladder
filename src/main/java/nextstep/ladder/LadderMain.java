package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.ladderview.InputView;
import nextstep.ladder.ladderview.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView(), new ResultView());

        ladderController.run();
    }
}
