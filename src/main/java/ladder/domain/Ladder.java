package ladder.domain;

public class Ladder {

    private final Participants participants;
    private final LadderHeight height;
    private final Lines lines;

    public Ladder(final Participants participants, final LadderHeight height, final Lines lines) {
        this.participants = participants;
        this.height = height;
        this.lines = lines;
    }

    public Participants getParticipants() {
        return new Participants(participants);
    }

    public LadderHeight getHeight() {
        return this.height;
    }

    public Lines getLines() {
        return this.lines;
    }

    public Line getLine(final int index) {
        return this.lines.getLines()
                         .get(index);
    }
}
