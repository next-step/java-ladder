package ladder.controller;

import ladder.common.utils.TextManipulator;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.horizontallinecreationstrategy.RandomHorizontalLineStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        String[] members = TextManipulator.splitTextByComma(InputView.inputNamesInOneLine());
        int heightOfLadder = InputView.inputHeightOfLadder();

        RandomHorizontalLineStrategy randomHorizontalLineStrategy = new RandomHorizontalLineStrategy();
        LadderGame ladderGame = new LadderGame(randomHorizontalLineStrategy, members);
        Ladder ladder = ladderGame.generateLadder(heightOfLadder);

        OutputView.printResult(ladderGame.members(), ladder);
    }
}
