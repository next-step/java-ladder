package ladder;

import ladder.controller.LadderController;

public class LadderMain {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.generateLadder();
    }
}
