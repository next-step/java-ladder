package ladder.line;

import java.util.ArrayList;
import java.util.List;
import ladder.exception.InvalidHeightException;
import ladder.exception.InvalidLinesException;

public class Lines {

    private final List<Line> lines;
    private final int height;

    public Lines(int height) {
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

    private void validateLines(List<Line> lines) {
        long barCount = lines.stream()
                .filter(this::validateLine)
                .count();
        if (barCount != height) {
            throw new InvalidLinesException();
        }
    }

    private boolean validateLine(Line line) {
        return line.validate();
    }
}
