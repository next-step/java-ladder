package ladder.domain;

import java.util.stream.Stream;

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
        return Stream.generate(lineGenerator::generate)
                .limit(height)
                .collect(collectingAndThen(toList(), Ladder::new));
    }
}
