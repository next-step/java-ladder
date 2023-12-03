package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.model.Height.MIN_LADDER_HEIGHT;

public class Lines {
    private final List<Line> lines;
    private final int height;

    public Lines(List<Line> lines, Height height) {
        this.lines = lines;
        this.height = height.height();
    }

    public Lines(List<Line> lines) {
        this(lines, new Height(MIN_LADDER_HEIGHT));
    }

    public int height() {
        return this.height;
    }

    public List<Boolean> horizonLineDrawAvailable(int index) {
        return this.lines.stream()
                .map(line -> line.point(index))
                .map(point -> point.equals(Point.LEFT))
                .collect(Collectors.toList());
    }

    public int move(int depth, int lineIndex) {
        if (depth == height) {
            return lineIndex;
        }
        Line selectLine = this.lines.get(lineIndex);
        lineIndex = move(depth + 1, lineIndex + selectLine.move(depth));
        return lineIndex;
    }

    public int lineCount() {
        return this.lines.size();
    }

}
