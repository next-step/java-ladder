package nextstep.ladder.domain;

public class LadderGame {
    private final ParticipantNames participantNames;
    private final Lines lines;

    public LadderGame(ParticipantNames participantNames, Height height, GenerateLadderPointStrategy generateLadderPointStrategy) {
        this.participantNames = participantNames;
        this.lines = new Lines(participantNames.size(), height, generateLadderPointStrategy);
    }

    public ParticipantNames getParticipantNames() {
        return participantNames;
    }

    public Lines getLines() {
        return lines;
    }

}
