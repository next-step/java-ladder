package ladder.domain;

import ladder.domain.generator.PointGenerator;

import java.util.List;
import java.util.Objects;
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

        if (startPosition < 0 || startPosition >= maxIndex()) {
            throw new IllegalArgumentException("시작 위치가 유효하지 않습니다.");
        }

        int position = startPosition;
        for (Line line : lines) {
            position = line.move(position);
        }

        return position;
    }

    private int maxIndex() {

        return lines.size() - 1;
    }

    public List<Line> getLines() {

        return lines;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lines);
    }
}
