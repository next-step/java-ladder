package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final int sizeOfPerson;
    private final List<Line> lines;

    public Ladder(final int sizeOfPerson, final List<Line> lines) {
        this.sizeOfPerson = sizeOfPerson;
        this.lines = lines;
    }

    public void play() {
        for (int i = 0; i < sizeOfPerson; i++) {
            move(i);
        }
    }

    public int move(final int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(result);
        }
        return result;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
