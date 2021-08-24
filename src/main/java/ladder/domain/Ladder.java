package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int personCount, LineGenerateStrategy lineGenerateStrategy) {
        IntStream.range(0, height)
                .forEach(idx -> lines.add(new Line(personCount, lineGenerateStrategy)));
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
