package ladder;

import ladder.controller.LadderController;

public class LadderGame {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController();

        ladderController.run();
    }
}
