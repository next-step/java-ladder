package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;

public class LadderGameApplication {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.start();
    }
}
