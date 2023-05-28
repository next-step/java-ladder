package step4.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfPerson, int height) {
        this.lines = IntStream.range(0, height)
                .mapToObj(Line::new)
                .collect(Collectors.toList());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int findPositionByIndex(int initIndex) {
        int resultIndex = initIndex;
        for (Line line : lines) {
            resultIndex = line.nextPosition(resultIndex);
        }
        return resultIndex;
    }
}
