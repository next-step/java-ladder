package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.RandomCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final String NEW_LINE = "\n";

    private final List<Line> lines;

    public Ladder(final int width, final int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, new RandomCreateStrategy()));
        }

        this.lines = lines;
    }

    public LadderResult start(final Participants participants, final Results result) {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < participants.countOfPerson(); i++) {
            final Position endPosition = move(Position.of(i));
            ladderResult.put(participants.get(i), result.get(endPosition));
        }

        return ladderResult;
    }

    public Position move(final Position startPosition) {
        Position currentPosition = startPosition;
        for (Line line: this.lines) {
            currentPosition = line.move(currentPosition);
        }

        return currentPosition;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.lines.forEach(l -> stringBuilder.append(l.toString()).append(NEW_LINE));

        return stringBuilder.toString();
    }
}
