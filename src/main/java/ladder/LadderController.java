package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private static final String END_OF_RESULT = "all";

    public static void main(String[] args) {
        LadderGame ladderGame = createLadderGame();
        printGameResult(ladderGame);
    }

    private static void printGameResult(LadderGame ladderGame) {
        ResultView resultView = new ResultView();
        resultView.printLadderResult(ladderGame.getUsers(), ladderGame.getLadder(), ladderGame.getResults());

        while (true) {
            String name = resultView.inputNameForResult();
            if (name.equalsIgnoreCase(END_OF_RESULT)) {
                resultView.printGameResult(ladderGame);
                break;
            }
            resultView.printResult(ladderGame.getResult(name));
        }
    }

    public static LadderGame createLadderGame() {
        InputView inputView = new InputView();
        Users users = Users.from(inputView.inputUserNames());
        List<String> results = inputView.inputResults();
        Ladder ladder = LadderFactory.INSTANCE.generateLadder(users.size(), new LadderHeight(inputView.inputLadderHeight()));

        return new LadderGame(users, ladder, results);
    }
}
