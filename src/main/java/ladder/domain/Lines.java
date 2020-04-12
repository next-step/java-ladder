package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private static final int ZERO = 0;

    private final List<Line> lines;

    public Lines() {
        this.lines = new ArrayList<>();
    }

    public Lines(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Lines of(final int playerCount, final int ladderHeight, final LadderMoveStrategy strategy) {
        Lines lines = new Lines();
        for (int i = 0; i < ladderHeight; i++) {
            lines = lines.addLine(Line.of(playerCount, strategy));
        }
        return lines;
    }

    private Lines addLine(final Line line) {
        List<Line> merge = new ArrayList<>();
        merge.addAll(this.lines);
        merge.add(line);
        return new Lines(merge);
    }

    public Node move(int nodeNumber) {
        for (Line line : lines) {
            nodeNumber = line.move(nodeNumber);
        }
        return getLastLine().getNode(nodeNumber);
    }

    public int getStartPointCount() {
        return this.lines.get(ZERO).getNoteSize();
    }

    private Line getLastLine() {
        return this.lines.get(size() - 1);
    }

    private int size() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
