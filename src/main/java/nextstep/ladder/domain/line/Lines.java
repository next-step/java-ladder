package nextstep.ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private List<Line> lines;

    public Lines(int height, int countOfPerson) {
        this(toLines(height, countOfPerson));
    }

    private static List<Line> toLines(int height, int countOfPerson) {
        return IntStream.range(0, height)
            .mapToObj(currentHeight -> new Line(countOfPerson))
            .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int size() {
        return lines.size();

    }
}
