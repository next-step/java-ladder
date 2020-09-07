package nextstep.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final List<Line> lines;

    private Ladder(Personnel personnel, Length length) {
        this.lines = IntStream.range(START_INDEX, length.getLength())
                .mapToObj(index -> Line.of(personnel.getPersonnel()))
                .collect(Collectors.toList());
    }

    public List<List<Boolean>> getLinesStatus() {
        return this.lines.stream().map(Line::getPedalsStatus).collect(Collectors.toList());
    }

    public static Ladder of(Personnel personnel, Length length) {
        return new Ladder(personnel, length);
    }
}
