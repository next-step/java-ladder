package nextstep.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final Entries entries;
    private final List<Line> lines;

    public Ladder(Entries entries, Length length) {
        this.entries = entries;
        int personnel = entries.getPersonnel();
        this.lines = IntStream.range(START_INDEX, length.getLength())
                .mapToObj(index -> new Line(personnel))
                .collect(Collectors.toList());
    }

    public List<String> getEntryNames() {
        return this.entries.getNames();
    }

    public List<List<Boolean>> getResult() {
        return this.lines.stream().map(Line::getResult).collect(Collectors.toList());
    }
}
