package nextstep.controller;

import nextstep.domain.Lines;
import nextstep.domain.Username;
import nextstep.view.InputView;
import nextstep.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    public static void main(String[] args) {
        List<String> usernames = InputView.inputUserNames();
        int ladderHeight = InputView.inputLadderHeightMax();

        Lines lines = new Lines(usernames.size(), ladderHeight);
        OutputView.outputUserNames(usernames);
        OutputView.outputLadder(lines);
    }
}
