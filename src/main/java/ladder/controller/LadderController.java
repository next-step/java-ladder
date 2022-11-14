package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final DirectionGenerator directionGenerator = new RandomDirectionGenerator();

    public void run() {
        Users users = new Users(InputView.inputNames());
        Ladder ladder = new Ladder(users.size(), InputView.inputHeight(), directionGenerator);
        Results results = new Results(InputView.inputResults());

        GameResult gameResult = ladder.play(users, results);

        OutputView.printLadderResult(new LadderResult(users, ladder, results));
        printGameResult(gameResult);
    }

    private void printGameResult(GameResult gameResult) {
        boolean gameEnd = false;
        while (!gameEnd) {
            gameEnd = OutputView.printGameResult(gameResult, InputView.inputName());
        }
    }
}
