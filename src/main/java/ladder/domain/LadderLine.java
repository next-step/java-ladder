package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private List<Line> lines;

    LadderLine(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> newLineOnBeforeLine(int height) {
        List<Line> innerLadderLine = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            RandomLinkStrategy randomLinkStrategy = new RandomLinkStrategy();
            Line newLineBasedBeforeLine = Line.newLineBasedBeforeLine(lines.get(i), randomLinkStrategy);
            innerLadderLine.add(newLineBasedBeforeLine);
        }
        return innerLadderLine;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "lines=" + lines +
                '}';
    }
}
