package nextstep.ladder.domain;

public class LadderGame {

    private final Participants participants;

    private final Lines lines;

    public LadderGame(String[] participants, int height) {
        this.participants = new Participants(participants);
        this.lines = new Lines(height, this.participants.numberOfParticipants());
    }

    public Lines lines2() {
        return lines;
    }

    public Participants participants() {
        return participants;
    }
}
