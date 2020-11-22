package ladder.domain.generator;

import ladder.domain.model.Ladder;
import ladder.domain.model.Line;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderGenerator implements Generator<Ladder> {
    private final int height;
    private final Generator<Line> lineGenerator;

    public LadderGenerator(int height, Generator<Line> lineGenerator) {
        this.height = height;
        this.lineGenerator = lineGenerator;
    }

    @Override
    public Ladder generate() {
        return IntStream.range(0, height)
                .mapToObj(i -> lineGenerator.generate())
                .collect(collectingAndThen(toList(), Ladder::new));
    }
}
