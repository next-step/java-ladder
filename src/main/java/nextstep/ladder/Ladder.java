package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfHeight, int countOfPerson) {
        lines = makeLadder(countOfHeight, countOfPerson);
    }

    private List<Line> makeLadder(int countOfHeight, int countOfPerson) {
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
}
