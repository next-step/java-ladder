package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.exception.InvalidHeightException;
import ladder.exception.InvalidLinesException;
import ladder.line.Line;

public class Ladder {

    private final List<Line> lines;
    private final Names names;
    private final int height;

    public Ladder(List<String> names, int height) {
        this.names = new Names(names);

        if (height <= 0) {
            throw new InvalidHeightException();
        }
        this.height = height;

        this.lines = new ArrayList<>();
    }

    public void addLines(List<Line> lines) {
        validateLines(lines);

        this.lines.addAll(lines);
    }

    public Line getLine(int index) {
        return this.lines.get(index);
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public int getHeight() {
        return this.height;
    }

    public List<String> getNames() {
        return this.names.getNames();
    }

    public int getMaxNameLength() {
        return this.names.getMaxNameLength();
    }

    private void validateLines(List<Line> lines) {
        long barCount = lines.stream()
                .filter(this::validateLine)
                .count();
        if (barCount != height) {
            throw new InvalidLinesException();
        }
    }

    private boolean validateLine(Line line) {
        List<Boolean> bars = line.getBars();
        if (bars.size() != getNames().size()) {
            return false;
        }

        return line.validate();
    }


}
