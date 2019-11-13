package ladder.domain;

public class LadderGame {

    private final Participants participants;
    private final Ladders ladders;

    private LadderGame(Participants participants, Height height) {
        this.participants = participants;
        this.ladders = generateLadders(participants, height);
    }

    private Ladders generateLadders(Participants participants, Height height) {
        return new Ladders(participants.getNumberOfParticipants(), height.getHeight());
    }

    public static LadderGame of(Participants participants, Height height) {
        return new LadderGame(participants, height);
    }

    public String getParticipantsString() {
        return participants.toString();
    }

    public String getLadderString() {
        return ladders.toString();
    }
}
