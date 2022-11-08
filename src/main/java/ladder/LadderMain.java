package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.stream.Collectors;

public class LadderMain {

    public static void main(String[] args) {
        final Participants participants = new Participants(InputView.inputParticipantNames()
                                                                    .stream()
                                                                    .map(Participant::new)
                                                                    .collect(Collectors.toList()));
        final LadderHeight ladderHeight = new LadderHeight(InputView.inputLadderHeight());
        final Ladder ladder = LadderFactory.create(participants, ladderHeight);
        ResultView.print(ladder);
    }
}
