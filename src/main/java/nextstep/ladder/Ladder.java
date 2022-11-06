package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private List<Line> lines;

    public Ladder(int countOfPerson, LadderMaxHeight maxHeight) {
        this(generateLines(countOfPerson, maxHeight));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private static List<Line> generateLines(int countOfPerson, LadderMaxHeight maxHeight) {
        return Stream.generate(() -> LineFactory.randomLine(countOfPerson))
                .limit(maxHeight.getValue())
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
