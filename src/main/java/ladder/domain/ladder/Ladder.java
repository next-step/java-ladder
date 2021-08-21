package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public final class Ladder {

    public static final int MIN_USER_COUNT = 2;
    public static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(final DirectionStrategy directionStrategy, final int ladderHeight, final int userCount) {
        lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(directionStrategy, userCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
