package ladder.domain;

import java.util.HashSet;
import java.util.Set;

public class Lines {
    private final Set<Line> lines;

    public Lines(int height, int width, int count) {
        Set<Line> newLines = new HashSet<>();
        while (newLines.size() >= count) {
            newLines.add(Line.any(LineStrategyRandom.of(height, width)));
        }
        lines = newLines;
    }

    public int lineCount() {
        throw new RuntimeException("Not Yet Implemented");
    }

    public Set<Line> allLines() {
        return lines;
    }

    public boolean existLine(int i, int j) {
        return lines.stream().filter(line -> line.isYourPosition(i, j)).findFirst().isPresent();
    }
}
