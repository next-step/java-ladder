package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int count, Height height) {
        List<Line> lines = IntStream.range(0, count)
                .mapToObj(i -> new Line(height))
                .collect(Collectors.toList());

        Line prev = lines.get(0);
        for (int i = 1; i < count; i++) {
            Line curLine = lines.get(i);
            curLine.addBridges(prev);
            prev = curLine;
        }
        return new Lines(lines);
    }
}
