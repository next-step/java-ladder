package ladder.UI;

import ladder.domain.ladder.LadderContext;
import ladder.domain.user.Participants;

public class ResponseDto {

    private final Participants participants;
    private final LadderContext ladderContext;

    public ResponseDto(Participants participants, LadderContext ladderContext) {
        this.participants = participants;
        this.ladderContext = ladderContext;
    }

    public Participants getParticipants() {
        return participants;
    }

    public LadderContext getLadderContext() {
        return ladderContext;
    }
}
