package ladder;

import java.util.List;
import ladder.line.Line;
import ladder.line.Lines;

public class Ladder {

    private final Lines lines;
    private final Names names;

    public Ladder(List<String> names, int height) {
        this.names = new Names(names);
        this.lines = new Lines(height);
    }

    public void addLines(List<Line> lines) {
        this.lines.addLines(lines);
    }

    public Line getLine(int index) {
        return this.lines.getLine(index);
    }

    public List<Line> getLines() {
        return this.lines.getLines();
    }

    public int getHeight() {
        return this.lines.getHeight();
    }

    public List<String> getNames() {
        return this.names.getNames();
    }

    public int getMaxNameLength() {
        return this.names.getMaxNameLength();
    }

}
