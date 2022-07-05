package nextstep.ladder.domain;

public class LadderGame {

    private final Participants participants;

    private final Lines lines;

    private final LadderResults ladderResults;

    public LadderGame(String[] participants, String[] ladderResults, int height) {
        this.participants = new Participants(participants);
        this.ladderResults = new LadderResults(ladderResults, this.participants.numberOfParticipants());
        this.lines = new Lines(height, this.participants.numberOfParticipants());
    }

    public String view() {
        return this.lines.toLadderLines();
    }

    public Participants participants() {
        return participants;
    }

    public LadderResults ladderResults() {
        return ladderResults;
    }
}
