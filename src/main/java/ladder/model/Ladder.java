package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder of(int width, int height, GenerationStrategy generationStrategy) {
        return IntStream.range(0, height)
                .mapToObj(index -> Line.of(width, index, generationStrategy))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    public List<Line> getLines() {
        return lines;
    }
}
