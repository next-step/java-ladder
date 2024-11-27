package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int height, int width) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(Line.of(width));
        }

        return new Lines(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
