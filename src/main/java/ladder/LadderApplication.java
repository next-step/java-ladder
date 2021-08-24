package ladder;

import ladder.controller.LadderController;

public class LadderApplication {

    public static void main(String[] args) {
        LadderController ladderController = LadderController.create();
        ladderController.run();
    }
}
