package ladder.domain.ladder.ladder;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.line.LineGenerator;

public class RandomLadderGenerator implements LadderGenerator {

    private final LineGenerator lineGenerator;

    public RandomLadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    @Override
    public Ladder generate(int numberOfRows, int numberOfColumns) {
        return IntStream.range(0, numberOfRows)
                .mapToObj(i -> lineGenerator.generate(numberOfColumns))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::of));
    }
}
