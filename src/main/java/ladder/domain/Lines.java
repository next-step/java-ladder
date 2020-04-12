package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private static final int ZERO = 0;

    private final List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Lines of(final int playerCount, final int ladderHeight, final LadderMoveStrategy strategy) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(Line.of(playerCount, strategy));
        }

        return new Lines(lines);
    }

    public Node move(int nodeNumber) {
        for (Line line : lines) {
            nodeNumber = line.move(nodeNumber);
        }
        return getLastLine().getNodes(nodeNumber);
    }

    public int getStartPointCount() {
        return this.lines.get(ZERO).size();
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
