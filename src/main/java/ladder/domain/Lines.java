package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines() {
        this.lines = new ArrayList<>();
    }

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final int playerCount, int ladderHeight) {
        Lines lines = new Lines();
        for (int i = 0; i < ladderHeight; i++) {
            lines = lines.addLine(Line.of(playerCount));
        }
        return lines;
    }

    private Lines addLine(Line line) {
        List<Line> merge = new ArrayList<>();
        merge.addAll(this.lines);
        merge.add(line);
        return new Lines(merge);
    }

    public int size() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }

    public Line getLine(int index) {
        Line line = this.lines.get(index);
        return line.clone();
    }
}
