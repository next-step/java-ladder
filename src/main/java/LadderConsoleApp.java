import console.ConsoleInput;
import console.ConsoleOutput;
import domain.DefaultLadderGenerator;
import domain.LadderGame;

import domain.LadderGenerator;
import java.util.List;

public class LadderConsoleApp {

    public static void main(String[] args) {
        final List<String> users = ConsoleInput.enterUsers();
        final int height = ConsoleInput.enterHeight();

        LadderGenerator ladderGenerator = new DefaultLadderGenerator();
        LadderGame ladderGame = new LadderGame(ladderGenerator);

        ladderGame.generate(height, users.size());

        ConsoleOutput.printResult(users,ladderGame);
    }
}
