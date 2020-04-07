package ladder.controller;

import ladder.domain.Entry;
import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;


public class LadderController {
    public static void main(String[] args) {
        Entry entry = InputView.inputEntry();
        int height = InputView.inputHeight();

        Ladder ladder = Ladder.of(entry.countOfParticipant(), height);
        ResultView.print(entry);
        ResultView.print(ladder);
    }
}
