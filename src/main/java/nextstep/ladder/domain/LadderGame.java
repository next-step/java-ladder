package nextstep.ladder.domain;

public class LadderGame {
    private final Participants participants;
    private final Lines lines;

    public LadderGame(Participants participants, Height height, GenerateLadderPointStrategy generateLadderPointStrategy) {
        this.participants = participants;
        this.lines = new Lines(participants.size(), height, generateLadderPointStrategy);
    }

    public Participants getParticipantNames() {
        return participants;
    }

    public Lines getLines() {
        return lines;
    }

}
