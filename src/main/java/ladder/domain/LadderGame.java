package ladder.domain;

import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public void play() {
        Users users = InputView.inputParticipants();
        int ladderHeight = InputView.inputHeight();

        Ladder ladder = Ladder.of(users.size(), ladderHeight, new RandomPointStrategy());

        ResultView.printResult(users, ladder);
    }
}
