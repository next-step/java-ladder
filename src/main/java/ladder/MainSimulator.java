package ladder;

import ladder.controller.LadderGameController;

public class MainSimulator {
    private static final LadderGameController ladderGameController = new LadderGameController();
    public static void main(String[] args) {
        ladderGameController.getLadderGameInformation();
    }
}
