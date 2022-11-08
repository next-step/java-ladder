package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Lines {

    private final List<Line> lines;

    public Lines(final List<Line> lines) {
        validateLinesOrThrow(lines);

        this.lines = lines;
    }

    public int height() {
        return this.lines.size();
    }

    public int width() {
        return this.lines.get(0)
                         .size();
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public Line getLine(final int index) {
        return this.lines.get(index);
    }

    private void validateLinesOrThrow(final List<Line> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            throw new IllegalArgumentException("최소 1개 이상의 사다리 라인이 필요합니다.");
        }

        if (lines.stream()
                 .map(Line::size)
                 .distinct()
                 .count() != 1) {
            throw new IllegalArgumentException("모든 사다리 라인의 사이즈는 동일해야 합니다.");
        }
    }
}
