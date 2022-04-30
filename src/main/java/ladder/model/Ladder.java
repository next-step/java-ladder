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

    public static Ladder create(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder of(int width, int height, GenerationStrategy generationStrategy) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(index -> Line.of(width, generationStrategy))
                .collect(Collectors.toList());
        return create(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int index) {
        int movedIndex = index;
        for (Line line : lines) {
            movedIndex = line.move(movedIndex);
        }
        return movedIndex;
    }

}
