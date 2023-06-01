package ladder.domain;

public class LadderResultPrint {

    private final Participant participant;
    private final LadderResult ladderResult;

    public LadderResultPrint(Participant participant, LadderResult ladderResult) {
        this.participant = participant;
        this.ladderResult = ladderResult;
    }

    public String getParticipantName() {
        return participant.getName();
    }

    public String getResult() {
        return ladderResult.getResult();
    }
}
