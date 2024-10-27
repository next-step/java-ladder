package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;

public class LadderGameMain {
    private static final LadderGame ladderGame = new LadderGame();

    public static void main(String[] args) {
        ladderGame.start();
    }
}
