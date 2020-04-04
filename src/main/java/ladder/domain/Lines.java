package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines() {
        this.lines = new ArrayList<Line>();
    }

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public Lines addLine(Line line) {
        List<Line> merge = new ArrayList<>();
        merge.addAll(this.lines);
        merge.add(line);
        return new Lines(merge);
    }

    public int size() {
        return this.lines.size();
    }

    public Line getLine(int index) {
        Line line = this.lines.get(index);
        return line.clone();
    }
}
