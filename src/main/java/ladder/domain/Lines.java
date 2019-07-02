package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private List<Line> lines;

    public Lines(List<Line> lines) {

        this.lines = lines;
    }

    public static Lines of(int width, int height) {

        return new Lines(IntStream.range(0, height)
                .mapToObj(currentHeight -> new Line(width))
                .collect(Collectors.toList()));
    }

    public List<Line> getLines() {

        return lines;
    }
}
