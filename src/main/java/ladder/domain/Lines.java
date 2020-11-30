package ladder.domain;

import java.util.List;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(List<Line> lines) {
        if(lines == null)
            throw new NullPointerException();

        return new Lines(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
