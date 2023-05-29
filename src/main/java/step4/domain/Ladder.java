package step4.domain;

import step3.domain.InputValidator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfPerson, int height) {
        InputValidator.validateHeight(height);
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson))
                .collect(Collectors.toList());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int findResultPositionByIndex(int initIndex) {
        int resultIndex = initIndex;
        for (Line line : lines) {
            resultIndex = line.nextPosition(resultIndex);
        }
        return resultIndex;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
