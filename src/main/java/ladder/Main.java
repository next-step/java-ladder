package ladder;

import ladder.controller.LadderGame;
import ladder.exception.TooLongNameException;

public class Main {

    public static void main(String[] args) throws TooLongNameException {
        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }
}
