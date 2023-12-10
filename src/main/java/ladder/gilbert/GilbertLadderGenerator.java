package ladder.gilbert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.engine.*;
import ladder.gilbert.domain.data.Goals;
import ladder.gilbert.domain.data.LadderHeight;

public class GilbertLadderGenerator implements LadderGenerator {

    private final LineGenerator lineGenerator;

    public GilbertLadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    @Override
    public Ladder generate(Goals goals, LadderHeight ladderHeight) {
        List<Line> lines = Stream.generate(() -> lineGenerator.generate(goals.size()))
            .limit(ladderHeight.value())
            .collect(Collectors.toList());
        return new GilbertLadder(lines, goals);
    }
}
