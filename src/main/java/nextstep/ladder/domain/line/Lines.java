package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int height, int width) {
        this.lines = createLines(height, width);
    }

    private List<Line> createLines(int height, int width) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }

        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
