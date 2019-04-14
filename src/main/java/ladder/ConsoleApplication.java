package ladder;

import ladder.domain.BetItems;
import ladder.domain.GameResults;
import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.domain.generator.RandomLadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Players players = Players.valueOfComma(InputView.inputNames(scanner));
        BetItems ladderResults = BetItems.valueOfComma(InputView.inputResults(scanner));

        int height = InputView.inputHeight(scanner);

        LadderGame ladderGame = new LadderGame(new RandomLadderGenerator());
        ladderGame.init(players.getCount(), height);
        OutputView.printLadder(players, ladderGame, ladderResults);

        GameResults gameResults = ladderGame.play(players, ladderResults);

        String selectionResult = null;
        do {
            selectionResult = InputView.inputSelectedPlayer(scanner);
            OutputView.printResult(gameResults, selectionResult);
        } while (!OutputView.isEndAnswer(selectionResult));
        OutputView.endResult(gameResults);
    }
}
