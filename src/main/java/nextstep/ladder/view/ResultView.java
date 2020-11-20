package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;

public interface ResultView {
    void printParticipants(Participants participants);

    void printLadder(Ladder ladder);
}
