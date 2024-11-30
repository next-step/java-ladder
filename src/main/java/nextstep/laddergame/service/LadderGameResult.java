package nextstep.laddergame.service;

import nextstep.laddergame.domain.LadderOutput;
import nextstep.laddergame.domain.Participant;

public class LadderGameResult {
    private final Participant participant;
    private final LadderOutput ladderOutput;

    public LadderGameResult(Participant participant, LadderOutput ladderOutput) {
        this.participant = participant;
        this.ladderOutput = ladderOutput;
    }

    public String getWinningData() {
        return ladderOutput.getWinningData();
    }

    public Participant getParticipant() {
        return participant;
    }
}
