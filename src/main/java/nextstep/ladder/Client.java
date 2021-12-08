package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;

public class Client {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        ladderGame.start();
    }
}
