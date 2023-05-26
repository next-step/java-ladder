package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;
    private final Height height;

    public static Lines of(int countOfPerson, int height) {
        List<Line> newLine = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson))
                .collect(Collectors.toList());
        return new Lines(newLine, height);
    }

    public Lines(List<Line> lines, int height) {
        this.lines = lines;
        this.height = new Height(height);
    }

    public List<Line> getLines() {
        return lines;
    }
}
