package laddergameRDD;

import laddergameRDD.domain.GameResult;
import laddergameRDD.domain.Ladder;
import laddergameRDD.domain.RandomSelectStrategy;
import laddergameRDD.domain.LadderGame;
import laddergameRDD.view.InputView;
import laddergameRDD.view.OutputView;

import java.util.List;

public class LadderGameMain {
    public static void main(String[] args) {
        List<String> users = InputView.inputUsers();
        List<String> results = InputView.inputResults();
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        Ladder ladder = new Ladder(maxLadderHeight, users.size(), new RandomSelectStrategy());
        OutputView.printGameMap(users, results, ladder);

        LadderGame ladderGame = new LadderGame();
        List<GameResult> gameResults = ladderGame.play(ladder, users, results);

        String target = InputView.inputTarget();
        OutputView.printResult(gameResults, target);
    }
}
