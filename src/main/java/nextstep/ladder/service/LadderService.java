package nextstep.ladder.service;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;

public class LadderService {

    public List<Participant> startLadderGame(Ladder ladder, List<Participant> participants) {
        for (Participant participant : participants) {
            ladder.startGame(participant);
        }
        return participants;
    }
}
