package laddergame.v2.domain;

import java.util.ArrayList;
import java.util.List;

public class LineBasedLadderGenerator implements LadderGenerator {
    private final LineGenerator lineGenerator;

    public LineBasedLadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    @Override
    public Ladder generate(int playerCount, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(playerCount));
        }
        return new Ladder(lines);
    }
}
