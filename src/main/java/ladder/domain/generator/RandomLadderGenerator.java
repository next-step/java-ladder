package ladder.domain.generator;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class RandomLadderGenerator implements LadderGenerator {
    private LineGenerator lineGenerator = new RandomLineGenerator();

    @Override
    public Ladder generate(int countOfPerson, int height) {
        List<Line> lines = new ArrayList<>(height);
        setLines(lines, height, countOfPerson);
        return new Ladder(lines);
    }

    private void setLines(List<Line> lines, int height, int countOfPerson) {
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(countOfPerson));
        }
    }
}
