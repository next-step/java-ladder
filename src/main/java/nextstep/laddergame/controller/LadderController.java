package nextstep.laddergame.controller;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Participants;
import nextstep.laddergame.domain.Person;
import nextstep.laddergame.domain.dto.LadderDTO;

import java.util.List;

public class LadderController {

    private Participants participants;
    private Ladder ladder;

    public List<Person> initParticipants(String participants) {
        this.participants = Participants.create(participants);

        return this.participants.getParticipants();

    }

    public LadderDTO createLadder(int ladderHeight) {
        this.ladder = Ladder.of(participants.getParticipantCount(), ladderHeight);
        return LadderDTO.from(this.ladder);
    }
}
