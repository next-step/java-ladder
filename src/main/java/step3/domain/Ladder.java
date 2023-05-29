package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfPerson, int height) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson))
                .collect(Collectors.toList());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int findResultIndexBy(int initIndex) {
        int resultIndex = initIndex;
        for (Line line : lines) {
            resultIndex = line.nextIndex(resultIndex);
        }
        return resultIndex;
    }
}
