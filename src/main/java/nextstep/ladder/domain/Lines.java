package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private List<Line> lines = new ArrayList<>();

    public void addLine(final Line addLine) {
        if (!isConflict(addLine)) {
            lines.add(addLine);
        }
    }

    public boolean isConflict(final Line addLine) {
        return this.lines
                .stream()
                .anyMatch(line -> line.isConflict(addLine));
    }

    public boolean hasLine(final Line line) {
        return lines.contains(line);
    }

}
