package nextstep.ladder.domain;

public class LadderGame {

    private final Participants participants;

    private final Lines lines;

    private final Results results;

    public LadderGame(String[] participants, String[] ladderResults, int height) {
        this.participants = new Participants(participants);
        this.results = new Results(ladderResults, this.participants.numberOfParticipants());
        this.lines = new Lines(height, this.participants.numberOfParticipants());
    }

    public String view() {
        return this.lines.toLadderLines();
    }

    public Participants participants() {
        return participants;
    }
}
