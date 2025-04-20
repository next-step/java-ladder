package nextstep.ladder.domain;

import java.util.Iterator;
import java.util.List;

public class LadderLine {
    private final List<Boolean> lines;

    public LadderLine(List<Boolean> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("lines cannot be null or empty");
        }

        validateLines(lines);

        this.lines = lines;
    }

    private void validateLines(List<Boolean> lines) {
        Iterator<Boolean> iterator = lines.iterator();
        boolean prev = iterator.next();

        while (iterator.hasNext()) {
            boolean cur = iterator.next();
            if (prev && cur) {
                throw new IllegalArgumentException("Ladder lines cannot be connected continuously.");
            }
            prev = cur;
        }
    }
}
