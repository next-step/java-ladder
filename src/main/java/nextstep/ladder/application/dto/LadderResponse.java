package nextstep.ladder.application.dto;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.participant.Participants;


public class LadderResponse {
    private Lines lines;
    private Participants participants;

    public LadderResponse(Lines lines, Participants participants) {
        this.lines = lines;
        this.participants = participants;
    }

    public final Lines getLines() {
        return lines;
    }

    public final Participants getParticipants() {
        return participants;
    }
}
