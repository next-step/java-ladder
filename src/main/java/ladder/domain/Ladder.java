package ladder.domain;

public class Ladder {

    private final Participants participants;
    private final LadderHeight height;

    public Ladder(final Participants participants, final int height) {
        this(participants, new LadderHeight(height));
    }

    public Ladder(final Participants participants, final LadderHeight height) {
        this.participants = participants;
        this.height = height;
    }


    public Participants getParticipants() {
        return new Participants(participants);
    }

    public LadderHeight getHeight() {
        return this.height;
    }
}
