package camp.nextstep.edu.rebellion.refactoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int INIT_INDEX = 0;

    private final int sizeOfPerson;
    private final List<LadderLine> lines;

    public Ladder(int sizeOfLine, int sizeOfPerson) {
        this.sizeOfPerson = sizeOfPerson;
        lines = generateLines(sizeOfLine, sizeOfPerson);
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private List<LadderLine> generateLines(int sizeOfLine, int sizeOfPerson) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < sizeOfLine; i++) {
            lines.add(LadderLine.init(sizeOfPerson));
        }
        return lines;
    }
}
