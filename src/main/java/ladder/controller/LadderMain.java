package ladder.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import ladder.common.utils.TextManipulator;
import ladder.domain.GameResult;
import ladder.domain.GameResults;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderGenerator;
import ladder.domain.WinnerResult;
import ladder.domain.horizontallinecreationstrategy.RandomHorizontalLineStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        String[] members = TextManipulator.splitTextByComma(InputView.inputNamesInOneLine());
        GameResults gameResults = new GameResults(
            Arrays.stream(TextManipulator.splitTextByComma(InputView.inputResultOfLadder()))
                .map(GameResult::new)
                .collect(Collectors.toUnmodifiableList()), members);
        String heightOfLadder = InputView.inputHeightOfLadder();

        RandomHorizontalLineStrategy randomHorizontalLineStrategy = new RandomHorizontalLineStrategy();
        LadderGenerator ladderGenerator = new LadderGenerator(randomHorizontalLineStrategy, members, gameResults);
        Ladder ladder = ladderGenerator.generateLadder(heightOfLadder);

        OutputView.printResultOfLadder(ladderGenerator.members(), ladder, gameResults);

        while (true) {
            String climber = InputView.inputLadderClimber();
            LadderGame ladderGame = new LadderGame(ladderGenerator.members(), ladder, gameResults, climber);
            WinnerResult winnerResult = ladderGame.start();
            OutputView.printResultOfGame(climber, winnerResult);
        }
    }
}
