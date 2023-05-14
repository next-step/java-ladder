package nextstep.ladder.presentation;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;

import static nextstep.ladder.presentation.PromptMessage.*;

public class LadderGameResultView {
    private final ParticipantResultView participantResultView;
    private final LadderResultView ladderResultView;

    public LadderGameResultView(Participants participants, Ladder ladder) {
        participantResultView = new ParticipantResultView(participants);
        ladderResultView = new LadderResultView(ladder);
    }

    public void printExecuteResult() {
        System.out.println(EXECUTE_RESULT.message());
        participantResultView.printNames();
        ladderResultView.printLadder();
    }
}
