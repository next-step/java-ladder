package ladder.controller;

import ladder.common.utils.TextManipulator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        String[] members = TextManipulator.splitTextByComma(InputView.inputNamesInOneLine());
        int heightOfLadder = InputView.inputHeightOfLadder();

        OutputView.printResult();
    }
}
