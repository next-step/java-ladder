package ladder.domain;

import java.util.List;
import ladder.domain.line.Line;
import ladder.domain.line.Lines;

public class Ladder {

    private final Lines lines;
    private final Users users;

    public Ladder(List<String> names, int height) {
        this.users = new Users(names);
        this.lines = new Lines(height);
    }

    public void addLines(List<Line> lines) {
        this.lines.addLines(lines);
    }

    public List<Line> getLines() {
        return this.lines.getLines();
    }

    public List<String> getNames() {
        return this.users.getNames();
    }

    public int getMaxNameLength() {
        return this.users.getMaxNameLength();
    }

    public int getEndPoint(String name) {
        Point point = new Point(this.users.getIndex(name));
        getLines().forEach(point::move);

        return point.getIndex();
    }
}
