package ladder;

import ladder.controller.LadderController;

public class LadderGameRunner {
        public static void main(String[] args) {
                LadderController ladderController = new LadderController();
                ladderController.start();
        }
}
