package camp.nextstep.edu.rebellion.refactoring;

import camp.nextstep.edu.rebellion.domain.ladder.Row;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderLine> lines;

    public Ladder(int sizeOfLine, int sizeOfPerson) {
        lines = generateLines(sizeOfLine, sizeOfPerson);
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getFinalPosition(int startingPoint) {
        int currentPosition = startingPoint;
        for (LadderLine line : lines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

    private List<LadderLine> generateLines(int sizeOfLine, int sizeOfPerson) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < sizeOfLine; i++) {
            lines.add(LadderLine.init(sizeOfPerson));
        }
        return lines;
    }
}
