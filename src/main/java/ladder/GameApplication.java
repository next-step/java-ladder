package ladder;

import ladder.io.ConsoleInputHandler;
import ladder.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new ConsoleInputHandler(), new ConsoleOutputHandler());
        ladderGame.run();
    }
}
