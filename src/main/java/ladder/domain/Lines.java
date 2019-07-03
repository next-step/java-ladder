package ladder.domain;

import ladder.domain.generator.BooleanGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {

        this.lines = lines;
    }

    public static Lines of(LadderInfo ladderInfo, BooleanGenerator booleanGenerator) {
        return new Lines(IntStream.range(0, ladderInfo.getHeight())
                                 .mapToObj(currentHeight -> Line.of(ladderInfo.getWidth(), booleanGenerator))
                                 .collect(Collectors.toList()));
    }

    static Lines of(List<Line> lines) {

        return new Lines(lines);
    }

    public int move(int startPosition) {

        if (startPosition < 0 || startPosition >= maxWidth()) {
            throw new IllegalArgumentException("시작 위치가 유효하지 않습니다.");
        }

        int position = startPosition;
        for (Line line : lines) {
            position = line.move(position);
        }

        return position;
    }

    private int maxWidth() {

        return lines.size() - 1;
    }

    public List<Line> getLines() {

        return Collections.unmodifiableList(lines);
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
