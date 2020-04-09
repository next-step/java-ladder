package nextstep.ladder.domain.game;

public class LadderGameResult {
    private Participant participant;
    private Prize prize;

    public LadderGameResult(Participant participant,
                            Prize prize) {
        this.participant = participant;
        this.prize = prize;
    }

    public String getParticipantName() {
        return participant.getName();
    }

    public String getPrizeName() {
        return prize.getName();
    }
}
