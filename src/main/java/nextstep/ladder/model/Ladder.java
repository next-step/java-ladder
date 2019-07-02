package nextstep.ladder.model;

import nextstep.ladder.view.LineFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfHeight, int countOfPerson) {
        this.lines = makeLadder(countOfHeight, countOfPerson);
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    protected List<Line> makeLadder(int countOfHeight, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, countOfHeight)
                .forEach(height -> lines.add(new Line(countOfPerson)));
        return lines;
    }

    public String getFormattedLine() {
        LineFormatter lineFormatter = new LineFormatter();
        return lines.stream()
                .map(lineFormatter::format)
                .collect(Collectors.joining());
    }

    public List<Line> getLines() {
        return lines;
    }
}
