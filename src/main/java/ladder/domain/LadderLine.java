package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {

    private final List<Boolean> line;

    public LadderLine(int countOfPerson) {
        List<Boolean> lineList = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            if (i != 0 && lineList.get(i-1)) {
                lineList.add(false);
                continue;
            }
            lineList.add(CoordinateGeneration.generate());
        }
        this.line = lineList;
    }

    public List<Boolean> draw() {
        return Collections.unmodifiableList(line);
    }
}
