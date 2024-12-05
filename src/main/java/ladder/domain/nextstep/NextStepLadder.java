package ladder.domain.nextstep;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.Line;

import java.util.Collections;
import java.util.List;

public class NextStepLadder implements Ladder {

    private final List<Line> lines;

    private NextStepLadder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(List<Line> lines) {
        return new NextStepLadder(lines);
    }

    @Override
    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public int move(int startPosition) {
        int position = startPosition;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }
}
