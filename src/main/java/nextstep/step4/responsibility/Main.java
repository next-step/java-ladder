package nextstep.step4.responsibility;

import nextstep.step4.responsibility.domain.GameRunnable;
import nextstep.step4.responsibility.domain.Ladder;
import nextstep.step4.responsibility.domain.UserData;
import nextstep.step4.responsibility.input.ConsoleInputHandler;

public class Main {
    public static void main(String[] args) {
        final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
        final UserData userData = consoleInputHandler.inputUserData();
        final int height = consoleInputHandler.inputLadderHeight();

        GameRunnable gameRunner = new Ladder(userData, height);
        gameRunner.run();
    }
}
