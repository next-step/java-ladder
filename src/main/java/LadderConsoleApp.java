import console.ConsoleInput;
import console.ConsoleOutput;
import domain.DefaultLadderGenerator;
import domain.DefaultLineGenerator;
import domain.LadderGame;

import domain.LadderGenerator;
import domain.LineGenerator;
import domain.StoryResult;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class LadderConsoleApp {

    public static void main(String[] args) {
        final List<String> users = ConsoleInput.enterUsers();
        final List<String> results = ConsoleInput.enterResults();
        final int height = ConsoleInput.enterHeight();

        final LineGenerator lineGenerator = new DefaultLineGenerator();
        final LadderGenerator ladderGenerator = new DefaultLadderGenerator(lineGenerator);

        final LadderGame ladderGame = new LadderGame(ladderGenerator);

        ladderGame.generate(height, users.size());
        ConsoleOutput.printLadder(users, ladderGame, results);

        StoryResult gameResult = ladderGame.getResult();

        String userName = ConsoleInput.enterUserWantResult();
        while (!StringUtils.equals(userName, "all")) {
            ConsoleOutput.printResult(gameResult, users.indexOf(userName), results);
            userName = ConsoleInput.enterUserWantResult();
        }

        if (StringUtils.equals(userName, "all")) {
            ConsoleOutput.printResult(gameResult, users, results);
        }
    }
}
