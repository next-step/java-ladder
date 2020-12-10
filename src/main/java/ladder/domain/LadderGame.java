package ladder.domain;


import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private LineGenerator lineGenerator;

    public LadderGame(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder makeLadder(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = lineGenerator.generateLine(width);
            lines.add(line);
        }
        return new Ladder(lines);
    }
}
