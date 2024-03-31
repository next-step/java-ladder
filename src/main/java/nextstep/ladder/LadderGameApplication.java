package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;

public class LadderGameApplication {

    private static final LadderGameController ladderGameController = new LadderGameController();

    public static void main(String[] args) {
        ladderGameController.doLadderGame();
    }

}
