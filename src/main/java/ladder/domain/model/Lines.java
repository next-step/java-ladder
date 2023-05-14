package ladder.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    List<Line> lines;

    public Lines(int personCount, int ladderHeight) {
        lines = IntStream.range(0, ladderHeight)
                .mapToObj(i -> new Line(personCount))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "LadderGame{" +
                "lines=" + lines +
                '}';
    }
}
