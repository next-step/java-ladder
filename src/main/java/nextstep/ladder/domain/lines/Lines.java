package nextstep.ladder.domain.lines;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.domain.Line;

public class Lines {

    public static final String LINES_COUNT_EXCEPTION = "줄이 1개면 사다리를 생성할 수 없습니다.";
    public static final int MIN_SIZE = 1;

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    private void validateLines(List<Line> lines) {
        validateLinesCount(lines);
        validateSameLength(lines);
        validateLineOverlapping(lines);
    }

    private void validateLinesCount(List<Line> lines) {
        if (isMinimumSize(lines)) {
            throw new IllegalStateException(LINES_COUNT_EXCEPTION);
        }
    }

    private boolean isMinimumSize(List<Line> lines) {
        return lines.size() <= MIN_SIZE;
    }

    public void validateSameLength(List<Line> lines) {
        lines.forEach(line -> line.validateSameSizeAs(lines.get(0)));
    }

    public void validateLineOverlapping(List<Line> lines) {
        Line targetLine = lines.get(0);
        for (int lineIndex = 1; lineIndex < lines.size(); lineIndex++) {
            Line line = lines.get(lineIndex);
            targetLine.isOverlapping(line);
            targetLine = changeTarget(line);
        }
    }

    private Line changeTarget(Line line) {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
