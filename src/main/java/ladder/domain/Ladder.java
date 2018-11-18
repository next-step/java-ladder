package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    public Ladder() {
        lines = new ArrayList<>();
    }

    int generateLadder(int ladderHeight, int playerCount) {
        IntStream.range(0, ladderHeight)
                .forEach(i -> this.lines.add(Line.generateLine(playerCount)));

        return this.lines.size();
    }

    int moveLadder(int startPosition) {
        int pos = startPosition;

        for (Line line : lines) {
            pos = line.moveToNextPoint(pos);
        }

        return pos;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
