package ladder;

import java.util.List;

import ladder.model.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        List<String> participantNames = InputView.inputParticipants();

        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, participantNames.size());
        OutputView.printLadder(ladder);
    }
}
