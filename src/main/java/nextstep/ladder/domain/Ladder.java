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
            Position position = new Position(i);
            position = getPosition(position);

            ladderResult.put(participants.get(i), result.get(position));
        }
        return ladderResult;
    }

    private Position getPosition(Position position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.lines.forEach(l -> stringBuilder.append(l.toString()).append(NEW_LINE));

        return stringBuilder.toString();
    }
}
