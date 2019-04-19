package ladder;

import ladder.domain.*;
import ladder.domain.generator.ProbabilityValueGenerator;
import ladder.domain.generator.RandomLadderGenerator;
import ladder.domain.generator.RandomLineGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Players players = Players.valueOfComma(InputView.inputNames(scanner));
        BetItems ladderResults = BetItems.valueOfComma(InputView.inputResults(scanner));

        ComplexityType complexityType = ComplexityType.of(InputView.inputComplexity(scanner));

        LadderGame ladderGame = new LadderGame(new RandomLadderGenerator(new RandomLineGenerator(new ProbabilityValueGenerator(complexityType.getProbabilityOfLink()))));
        ladderGame.init(players.getCount(), complexityType.getHeight());
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