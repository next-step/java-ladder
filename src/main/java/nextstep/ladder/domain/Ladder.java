package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private final int sizeOfPerson;
    private final List<Line> lines;

    public Ladder(final int sizeOfPerson, final List<Line> lines) {
        this.sizeOfPerson = sizeOfPerson;
        this.lines = lines;
    }

    public int move(final int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(position);
        }
        return result;
    }
}
