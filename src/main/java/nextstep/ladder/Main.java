package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.view.LadderGameView;

public class Main {

    public static void main(String[] args) {
        LadderGameController.start(new LadderGameView());
    }
}
