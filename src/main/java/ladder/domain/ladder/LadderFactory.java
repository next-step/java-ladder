package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {

    public static Ladder makeLadder(LadderStructure ladderStructure, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderStructure.getHeight(); i++) {
            Line line = lineGenerator.generateLine(ladderStructure.getWidth());
            lines.add(line);
        }
        return new Ladder(lines);
    }
}
