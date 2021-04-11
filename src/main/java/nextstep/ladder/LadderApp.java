package nextstep.ladder;

import nextstep.ladder.controller.LadderController;

public class LadderApp {
    public static void main(String[] args) {
        LadderController ladderGame = new LadderController();
        ladderGame.start();
    }
}
