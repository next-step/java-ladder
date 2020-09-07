package nextstep.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final Personnel personnel;
    private final List<Line> lines;

    public Ladder(Personnel personnel, Length length) {
        this.personnel = personnel;
        this.lines = IntStream.range(START_INDEX, length.getLength())
                .mapToObj(index -> new Line(personnel.getPersonnel()))
                .collect(Collectors.toList());
    }

    public List<List<Boolean>> getLinesStatus() {
        return this.lines.stream().map(Line::getPedalsStatus).collect(Collectors.toList());
    }
}
