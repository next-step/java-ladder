package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> lines;

    public Lines(int numberOfPerson, int height) {
        this.lines = Stream.generate(() -> new Line(numberOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public Lines(List<Line> lineList) {
        this.lines = lineList;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines) {
            stringBuilder.append(line.print());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + lines +
                '}';
    }
}
