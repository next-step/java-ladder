package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final Names names;
    private final List<Line> lines;

    public Ladder(Names names, LadderHeight maxHeight) {
        this(names, generateLines(names.count(), maxHeight));
    }

    public Ladder(Names names, List<Line> lines) {
        this.names = names;
        this.lines = lines;
    }

    private static List<Line> generateLines(int count, LadderHeight maxHeight) {
        return Stream.generate(() -> LineFactory.randomLine(count))
                .limit(maxHeight.getValue())
                .collect(Collectors.toList());
    }

    public Names getNames() {
        return names;
    }

    public List<Line> getLines() {
        return lines;
    }
}
