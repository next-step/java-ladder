package ladder.domain;

import ladder.exception.LadderException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        validateHeight(height);

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = new Line(countOfPerson);
            lines.add(line);
        }
        this.lines = lines;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new LadderException();
        }
    }

    public int getResultPosition(int startPosition) {
        int position = startPosition;
        for (Line line : lines) {
            position = line.getAfterPosition(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
