package nextstep.ladder;

import nextstep.ladder.controller.LadderController;

public class LadderApp {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.start();
    }
}
