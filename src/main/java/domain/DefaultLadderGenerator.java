package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultLadderGenerator implements LadderGenerator {

    private final LineGenerator lineGenerator;

    public DefaultLadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    @Override
    public Ladder generate(int height, int lineSize) {
        List<Line> lines = Stream
            .generate(() -> lineGenerator.generate(lineSize))
            .limit(height)
            .collect(Collectors.toList());

        return new Ladder(lines);
    }
}
