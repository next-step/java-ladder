package ladder.domain;

import java.util.List;
import ladder.strategy.LinkStrategy;

public class Ladder {

    private final static String ERROR_ZERO_OR_NEGATIVE_VALUE = "0보다 큰 값만 입력 가능합니다.";

    private final Participants participants;
    private final Lines lines;

    public Ladder(final String participants, final int height) {
        validateHeight(height);
        this.participants = new Participants(participants);
        this.lines = new Lines(height, this.participants.size());
    }

    private void validateHeight(final int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ERROR_ZERO_OR_NEGATIVE_VALUE);
        }
    }

    public void draw(final LinkStrategy strategy) {
        lines.draw(strategy);
    }

    public List<Name> getParticipants() {
        return participants.getNames();
    }

    public List<Line> getLines() {
        return lines.getValue();
    }
}
