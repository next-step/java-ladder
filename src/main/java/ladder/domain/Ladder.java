package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.exception.LadderInvalidException;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfLines, int countOfPersons) {
        validateInput(countOfLines, countOfPersons);
        this.lines = createLines(countOfLines, countOfPersons);
    }

    private void validateInput(int countOfLines, int countOfPersons) {
        if (countOfLines < 1 || countOfPersons < 2) {
            throw new LadderInvalidException();
        }
    }

    private List<Line> createLines(int countOfLines, int countOfPersons) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < countOfLines; i++) {
            lines.add(new Line(countOfPersons));
        }

        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
