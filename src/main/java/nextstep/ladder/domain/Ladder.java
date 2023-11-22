package nextstep.ladder.domain;

public class Ladder {
    private Participants participants;
    private Lines lines;

    public Ladder(final Participants participants, final int ladderHeight) {
        this.participants = participants;
        this.lines = new Lines(participants.countOfPerson(), ladderHeight);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(participants.toString() + "\n");
        stringBuilder.append(lines.toString());
        return stringBuilder.toString();
    }
}
