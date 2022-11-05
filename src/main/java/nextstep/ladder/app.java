package nextstep.ladder;

import nextstep.ladder.strategy.RandomGenerator;
import nextstep.refactoring.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class app {

    public static void main(String[] args) {
        Users users = InputView.getUserNames();
        List<String> executeResult = InputView.getExecuteResult();
        int height = InputView.getHeight();

        Ladder ladder = new Ladder(height, users.getSize(), new RandomGenerator());

        ResultView.printNames(users.getUsers());
        ResultView.printLadder(ladder, executeResult);
        GameResults gameResults = GameResults.retrieveResults(users, ladder);

        while (true) {
            User resultUser = InputView.getUserNameForResult();
            ResultView.printGameResult(resultUser, gameResults, executeResult);
        }
    }

}
