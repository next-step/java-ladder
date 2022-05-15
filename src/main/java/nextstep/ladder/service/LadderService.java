package nextstep.ladder.service;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Participants;

import java.util.List;

public final class LadderService {

    public int gameParticipantCount(List<String> participantsNames) {
        return Participants.create(participantsNames);
    }

    public Ladder createLadder(int participant, int height) {
        return Ladder.createLadder(participant, height);
    }
}
