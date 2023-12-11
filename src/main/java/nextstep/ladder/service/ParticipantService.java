package nextstep.ladder.service;

import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.exception.CannotRegisterNameException;

public class ParticipantService {

    public void registerParticipant(String names) {
        Participants participants = new Participants(names);
    }
}
