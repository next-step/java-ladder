package nextstep.controller;

import nextstep.domain.Lines;
import nextstep.domain.Usernames;
import nextstep.view.InputView;
import nextstep.view.OutputView;

public class LadderGameController {

    public static void main(String[] args) {
        Usernames usernames = new Usernames(InputView.inputUserNames());
        int ladderHeight = InputView.inputLadderHeightMax();

        Lines lines = new Lines(usernames.size(), ladderHeight);
        OutputView.outputUserNames(usernames.getUsernames());
        OutputView.outputLadder(lines);
    }
}
