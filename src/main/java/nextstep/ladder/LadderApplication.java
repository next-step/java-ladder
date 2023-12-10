package nextstep.ladder;

import nextstep.ladder.controller.LadderController;

public class LadderApplication {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.game();
    }
}
