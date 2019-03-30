package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultLadderGenerator implements LadderGenerator {
    @Override
    public Ladder generate(int height, int countOfLines) {
        List<Line> lines = Stream.generate(() -> new Line(countOfLines))
                .limit(height)
                .collect(Collectors.toList());

        return new Ladder(lines);
    }
}
