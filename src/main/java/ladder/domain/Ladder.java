package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.exception.LadderInvalidException;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int ladderHeight, int countOfPersons) {
        validateInput(ladderHeight, countOfPersons);
        this.lines = createLines(ladderHeight, countOfPersons);
    }

    private void validateInput(int ladderHeight, int countOfPersons) {
        if (ladderHeight < 1 || countOfPersons < 2) {
            throw new LadderInvalidException();
        }
    }

    private List<Line> createLines(int ladderHeight, int countOfPersons) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countOfPersons));
        }

        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
