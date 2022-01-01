package nextstep.ladder.domain;

import java.util.List;

/**
 * @author han
 */
public class Lines {
    private final List<Line> lines;

    private Lines(List<Line> line) {
        this.lines = line;
    }

    public static Lines of(List<Line> lines) {
        return new Lines(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public Line getFirstLine() {
        return lines.get(0);
    }

    public Line move(int index) {
        return lines.get(index);
    }

    public int height() {
        return lines.size();
    }
}
