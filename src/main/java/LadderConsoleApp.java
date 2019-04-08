import console.ConsoleInput;
import console.ConsoleOutput;
import domain.*;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class LadderConsoleApp {
    public static final String ALL = "all";

    public static void main(String[] args) {
        final List<String> users = ConsoleInput.enterUsers();
        final List<String> results = ConsoleInput.enterResults();
        final DifficultyLevel difficultyLevel = ConsoleInput.enterDifficultyLevel();

        final LineGenerator lineGenerator = new DifficultyLevelLineGenerator(difficultyLevel);
        final LadderGenerator ladderGenerator = new DefaultLadderGenerator(lineGenerator);

        final LadderGame ladderGame = new LadderGame(ladderGenerator);

        ladderGame.generate(difficultyLevel.getHeight(), users.size());
        ConsoleOutput.printLadder(users, ladderGame, results);

        LadderGameResult gameResult = ladderGame.getResult();

        String userName = ConsoleInput.enterUserWantResult();
        while (!StringUtils.equals(userName, ALL)) {
            ConsoleOutput.printResult(gameResult, users.indexOf(userName), results);
            userName = ConsoleInput.enterUserWantResult();
        }

        if (StringUtils.equals(userName, ALL)) {
            ConsoleOutput.printResult(gameResult, users, results);
        }
    }
}
