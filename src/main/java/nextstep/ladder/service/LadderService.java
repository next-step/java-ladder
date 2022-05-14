package nextstep.ladder.service;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Participants;

import java.util.List;

public final class LadderService {

    public int gameParticipantCount(List<String> participantsNames) {
        return new Participants(participantsNames).size();
    }

    public Ladder createLadder(int height, int participant) {
        return new Ladder(height, participant);
    }
}
