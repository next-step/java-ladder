package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder createLadder(int width, int height, GenerateStrategy generateStrategy) {
        return IntStream.range(0, height)
                .mapToObj((index) -> Line.of(width, generateStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    public List<Line> getLines() {
        return lines;
    }
}
