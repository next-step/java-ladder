package ladder2;

import java.util.ArrayList;
import java.util.List;

public class LadderRandomGenerator implements LadderGenerator {

    private final LineGenerator lineGenerator;

    public LadderRandomGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    @Override
    public Ladder generateLadder(int playerCount, int height) {
        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(playerCount));
        }
        return new Ladder(lines);
    }
}
