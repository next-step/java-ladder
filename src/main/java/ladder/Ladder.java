package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private List<Line> lines;

    public Ladder(int inputLadderHeight, int playersCount, int prizes) {
        if (prizes != playersCount) {
            throw new IllegalArgumentException("플레이어와, 상품수는 같아야 합니다.");
        }
        this.lines = new ArrayList<>();
        createLadder(inputLadderHeight, playersCount);
    }

    public int move(int point) {
        for (Line line : lines) {
            point = line.move(point);
        }
        return point;
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
