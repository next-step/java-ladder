package ladder.controller;

import java.util.List;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<String> names = Names.from(inputView.inputParticipantsName()).toStringList();
        int height = inputView.inputMaximumHeight();

        Ladder ladder = Ladder.from(names.size(), height);
        resultView.outputLadder(ladder.toList(), names);

        inputView.scannerClose();
    }
}
