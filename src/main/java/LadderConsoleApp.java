import console.ConsoleInput;
import console.ConsoleOutput;
import domain.DefaultLadderGenerator;
import domain.LadderGame;

import java.util.List;

public class LadderConsoleApp {

    public static void main(String[] args) {
        final List<String> users = ConsoleInput.enterUsers();
        final int height = ConsoleInput.enterHeight();

        LadderGame ladderGame = new LadderGame(new DefaultLadderGenerator(), height, users.size());

        ConsoleOutput.printResult(users,ladderGame);
    }
}
