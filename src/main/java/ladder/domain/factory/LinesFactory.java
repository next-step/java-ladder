package ladder.domain.factory;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.generator.BooleanGenerator;
import ladder.domain.generator.RandomBooleanGenerator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinesFactory {

    private static final BooleanGenerator BOOLEAN_GENERATOR = new RandomBooleanGenerator();

    public static Lines createLines(int ladderWidth, int ladderHeight) {

        return new Lines(IntStream.range(0, ladderHeight)
            .mapToObj(currentHeight -> Line.of(ladderWidth, BOOLEAN_GENERATOR))
            .collect(Collectors.toList()));
    }
}
