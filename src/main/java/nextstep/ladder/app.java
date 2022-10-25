package nextstep.ladder;

import java.util.List;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class app {

    public static void main(String[] args) {
        Users users = InputView.getUserNames();
        List<String> executeResult = InputView.getExecuteResult();
        int height = InputView.getHeight();

        Ladder ladder = new Ladder(height, users.getSize(), new RandomGenerator());
        LadderGame ladderGame = new LadderGame(users, ladder);
        List<GameResult> gameResults = ladderGame.gameStart();

        ResultView.printNames(users.getUsers());
        ResultView.printLadder(ladder, executeResult);

        while (true) {
            User resultUser = InputView.getUserNameForResult();
            ResultView.printGameResult(resultUser, gameResults, executeResult);
        }
    }

}
