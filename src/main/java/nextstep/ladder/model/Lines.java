package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;
    private final int height;

    public Lines(List<Line> lines, Height height) {
        this.lines = lines;
        this.height = height.height();
    }

    public Lines(List<Line> lines) {
        this(lines, new Height(1));
    }

    public int height() {
        return this.height;
    }

    public List<Boolean> horizonLineDrawAvailable(int index) {
        return this.lines.stream()
                .map(line -> line.point(index))
                .collect(Collectors.toList());
    }
}
