package ladder.gilbert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.engine.*;

public class GilbertLadderGenerator implements LadderGenerator {

    private final LineGenerator lineGenerator;

    public GilbertLadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    @Override
    public Ladder generate(int numberOfPersons, int ladderHeight) {
        List<Line> lines = Stream.generate(() -> lineGenerator.generate(numberOfPersons))
            .limit(ladderHeight)
            .collect(Collectors.toList());
        return new GilbertLadder(lines);
    }
}
