package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Ladder {
    private Lines lines;

    public Ladder(final int width, final int height) {
        this.lines = new Lines(width, height);
    }

    public LadderResult start(final Participants participants, final Result result) {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < participants.countOfPerson(); i++) {
            final Participant participant = participants.of(i);
            final Position endPosition = lines.move(Position.of(i));

            ladderResult.put(participant, result.of(endPosition));
        }

        return ladderResult;
    }

    @Override
    public String toString() {
        return lines.toString();
    }
}
