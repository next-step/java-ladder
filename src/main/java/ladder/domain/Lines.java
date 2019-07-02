package ladder.domain;

import ladder.domain.generator.PointGenerator;
import ladder.domain.generator.RandomPointGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {

        this.lines = lines;
    }

    public static Lines of(int width, int height, PointGenerator pointGenerator) {

        return new Lines(IntStream.range(0, height)
                .mapToObj(currentHeight -> Line.of(width, pointGenerator))
                .collect(Collectors.toList()));
    }

    public static Lines of(List<Line> lines) {
        return new Lines(lines);
    }

    public int move(int startPosition) {

        int position = startPosition;
        for (Line line : lines) {
             position = line.move(position);
        }

        return position;
    }

    public List<Line> getLines() {

        return lines;
    }
}
