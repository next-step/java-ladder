package nextstep.controller;

import nextstep.domain.Lines;
import nextstep.view.InputView;
import nextstep.view.OutputView;

import java.util.List;

public class LadderGameController {

    public static void main(String[] args) {
        List<String> userNames = InputView.inputUserNames();
        int ladderHeight = InputView.inputLadderHeightMax();

        Lines lines = new Lines(userNames.size(), ladderHeight);
        OutputView.outputUserNames(userNames);
        OutputView.outputLadder(lines);
    }
}
