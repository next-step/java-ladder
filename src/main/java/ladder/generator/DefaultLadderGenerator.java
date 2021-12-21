package ladder.generator;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLadderGenerator implements LadderGenerator {

    private final LineGenerator lineGenerator;
    private final LadderHeight height;

    public DefaultLadderGenerator(LineGenerator lineGenerator, LadderHeight height) {
        this.lineGenerator = lineGenerator;
        this.height = height;
    }

    @Override
    public Ladder generate(int countOfPlayer) {
        List<Line> lines = IntStream.range(0, height.getHeight())
                .mapToObj(range -> lineGenerator.generate(countOfPlayer))
                .collect(Collectors.toList());
        return Ladder.createLadder(lines);
    }

}
