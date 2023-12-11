package nextstep.ladder.service;

import nextstep.ladder.domain.Participants;

public class ParticipantService {

    public Participants registerParticipant(String names) {
        Participants participants = new Participants(names);
        return participants;
    }
}
