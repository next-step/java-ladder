package nextstep.ladder.domain;

public class Ladder {
    public static final String NEW_LINE = "\n";
    private Participants participants;
    private Lines lines;

    public Ladder(final Participants participants, final int ladderHeight) {
        this.participants = participants;
        this.lines = new Lines(participants.countOfPerson(), ladderHeight);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(participants.toString() + NEW_LINE);
        stringBuilder.append(lines.toString());
        return stringBuilder.toString();
    }
}
