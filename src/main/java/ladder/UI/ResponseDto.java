package ladder.UI;

import ladder.domain.ladder.InputLadderResult;
import ladder.domain.ladder.LadderContext;
import ladder.domain.user.Participants;

public class ResponseDto {

    private final Participants participants;
    private final LadderContext ladderContext;
    private final InputLadderResult inputLadderResult;

    public ResponseDto(Participants participants, LadderContext ladderContext, InputLadderResult inputLadderResult) {
        this.participants = participants;
        this.ladderContext = ladderContext;
        this.inputLadderResult = inputLadderResult;
    }

    public Participants getParticipants() {
        return participants;
    }

    public LadderContext getLadderContext() {
        return ladderContext;
    }

    public InputLadderResult getInputLadderResult() {
        return inputLadderResult;
    }
}
