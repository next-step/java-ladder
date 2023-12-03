package ladder.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import ladder.common.utils.TextManipulator;
import ladder.domain.InputResult;
import ladder.domain.InputResults;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.horizontallinecreationstrategy.RandomHorizontalLineStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        String[] members = TextManipulator.splitTextByComma(InputView.inputNamesInOneLine());
        InputResults inputResults = new InputResults(
            Arrays.stream(TextManipulator.splitTextByComma(InputView.inputResultOfLadder()))
                .map(InputResult::new)
                .collect(Collectors.toUnmodifiableList()), members);
        int heightOfLadder = InputView.inputHeightOfLadder();

        RandomHorizontalLineStrategy randomHorizontalLineStrategy = new RandomHorizontalLineStrategy();
        LadderGame ladderGame = new LadderGame(randomHorizontalLineStrategy, members, inputResults);
        Ladder ladder = ladderGame.generateLadder(heightOfLadder);

        OutputView.printResult(ladderGame.members(), ladder, inputResults);
    }
}
