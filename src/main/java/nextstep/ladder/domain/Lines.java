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

    public boolean hasLine(final Line line) {
        return lines.contains(line);
    }

    public boolean isConflict(final Line addLine) {
        return this.lines
                .stream()
                .anyMatch(line -> line.isConflict(addLine));
    }

    public Position next(final Position position) {
        return this.lines
                .stream()
                .filter(line -> line.hasPosition(position))
                .map(line -> line.move(position).nextRowPosition())
                .findFirst()
                .orElse(position.nextRowPosition());
    }

}
