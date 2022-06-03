package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {

    private final DirectionGenerateStrategy generateStrategy;

    public LadderGenerator(DirectionGenerateStrategy generateStrategy) {
        this.generateStrategy = generateStrategy;
    }

    public Ladder createLadder(int width, int height) {
        return IntStream.range(0, height)
                .mapToObj((index) -> Line.of(width, generateStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }
}
