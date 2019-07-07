package ladder;

import java.util.List;

import ladder.model.Ladder;
import ladder.model.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

public final class LadderMain {
    public static void main(String[] args) {
        final List<String> participantNames = InputView.inputParticipants();
        final Participants participants = new Participants(participantNames);

        final int ladderHeight = InputView.inputLadderHeight();
        final Ladder ladder = new Ladder(ladderHeight, participantNames.size());

        OutputView.printResult(participants, ladder);
    }
}
