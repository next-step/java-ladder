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

    public Node move(final int nodeNumber) {
        int move = nodeNumber;
        for (Line line : lines) {
            move = line.getNodes().get(move).move();
        }
        return getLastLine().getNodes().get(move);
    }

    private Line getLastLine() {
        return this.lines.get(size() - 1);
    }

    public int size() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }
}
