package nextstep.ladder.domain;

import java.util.LinkedList;
import java.util.List;

public class Ladder {
    private final List<HorizontalLine> horizontalLines;

    public Ladder(List<HorizontalLine> horizontalLines) {
        this.horizontalLines = horizontalLines;
    }

    public Ladder(int userCount, int ladderMaxHeight) {
        this(generate(userCount, ladderMaxHeight));
    }

    private static List<HorizontalLine> generate(int userCount, int ladderMaxHeight) {
        List<HorizontalLine> horizontalLines = new LinkedList<>();

        for (int i = 0; i < ladderMaxHeight; i++) {
            horizontalLines.add(new HorizontalLine(userCount));
        }

        return horizontalLines;
    }

    public int size() {
        return horizontalLines.size();
    }
}
