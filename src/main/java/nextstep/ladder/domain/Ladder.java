package nextstep.ladder.domain;

public class Ladder {
    private final Lines lines;

    public Ladder(final int width, final int height) {
        this.lines = new Lines(width, height);
    }

    public LadderResult start(final Participants participants, final Results result) {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < participants.countOfPerson(); i++) {
            final Position endPosition = lines.move(Position.of(i));
            ladderResult.put(participants.get(i), result.get(endPosition));
        }

        return ladderResult;
    }

    @Override
    public String toString() {
        return lines.toString();
    }
}
