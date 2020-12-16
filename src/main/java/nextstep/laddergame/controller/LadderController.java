package nextstep.laddergame.controller;

import nextstep.laddergame.domain.Participants;

public class LadderController {

    private Participants participants;

    public void initParticipants(String participants) {
        this.participants = new Participants(participants);
    }
}
