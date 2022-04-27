package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines createLines(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width and height can't be negative number");
        }

        List<Line> lines = Line.createLines(width, height);
        return new Lines(lines);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
