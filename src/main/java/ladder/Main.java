package ladder;

import ladder.controller.GameResultController;
import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Players players = new Players(inputView.getPlayers());
        Results results = new Results(inputView.getResults());
        Height height = inputView.getHeight();
        Ladder ladder = new Ladder(height.getLength(), players.countOfPlayer(), results.countOfResult());
        resultView.printResult(players, ladder, results);

        GameResult gameResult = new GameResult(ladder, results);
        GameResultController controller = new GameResultController(players, gameResult);
        controller.printResult();
    }
}
