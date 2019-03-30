import console.ConsoleInput;
import console.ConsoleOutput;
import domain.DefaultLadderGenerator;
import domain.DefaultLineGenerator;
import domain.LadderGame;

import domain.LadderGenerator;
import domain.LineGenerator;
import java.util.List;

public class LadderConsoleApp {

    public static void main(String[] args) {
        final List<String> users = ConsoleInput.enterUsers();
        final int height = ConsoleInput.enterHeight();

        final LineGenerator lineGenerator = new DefaultLineGenerator();
        final LadderGenerator ladderGenerator = new DefaultLadderGenerator(lineGenerator);

        final LadderGame ladderGame = new LadderGame(ladderGenerator);

        ladderGame.generate(height, users.size());

        ConsoleOutput.printResult(users,ladderGame);
    }
}
