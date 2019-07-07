package ladder.model;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int numberOfParticipants) {
        lines = IntStream.range(0, height)
                         .mapToObj(i -> Line.generateRandom(numberOfParticipants))
                         .collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public List<Line> getLines() {
        return lines;
    }
}
