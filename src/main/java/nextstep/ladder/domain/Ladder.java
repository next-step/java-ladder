package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public PlayResults play(int sizeOfPerson) {
        List<PlayResult> result = new ArrayList<>();
        for (int i = 0; i < sizeOfPerson; i++) {
            result.add(move(i));
        }
        return new PlayResults(result);
    }

    private PlayResult move(final int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(result);
        }
        return new PlayResult(position, result);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
