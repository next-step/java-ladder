package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private List<Line> lines;

    public Ladder(int inputLadderHeight, int size) {
        this.lines = new ArrayList<>();
        createLadder(inputLadderHeight, size);
    }

    private void createLadder(int inputLadderHeight, int playerCount) {
        for (int i = 0; i < inputLadderHeight; i++) {
            Line line = new Line(LadderLineMakers.createLine(playerCount));
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
