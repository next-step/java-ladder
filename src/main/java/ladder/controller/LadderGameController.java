package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGameController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> names = inputView.inputParticipantsName();
        int height = inputView.inputMaximumHeight();

        Ladder ladder = Ladder.from(names.size(), height);
        resultView.outputLadder(ladder.toList(), names);

        inputView.scannerClose();
    }
}
