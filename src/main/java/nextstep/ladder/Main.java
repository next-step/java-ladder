package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.view.LadderGameInputView;
import nextstep.ladder.view.LadderGameOutputView;

public class Main {

    public static void main(String[] args) {
        LadderGameController.start(new LadderGameInputView(), new LadderGameOutputView());
    }
}
