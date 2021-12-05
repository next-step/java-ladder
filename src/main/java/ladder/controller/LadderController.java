package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        Names names = new Names(InputView.inputPlayerName());
        Height height = new Height(InputView.inputLadderHeight());
        Ladder ladder = new Ladder(names, height);
        ResultView.resultMessage();
        ResultView.printNames(names);
        ResultView.printLadder(ladder);

    }
}
