package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private static final int LINE_START_INDEX = 0;

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int height, int countOfParticipants) {
        this.lines = makeLines(height, countOfParticipants);
    }

    private List<Line> makeLines(int height, int countOfParticipants) {
        return IntStream.range(LINE_START_INDEX, height)
                .mapToObj(index -> new Line(countOfParticipants))
                .collect(Collectors.toList());
    }

    public List<Line> getLineCollection() {
        return Collections.unmodifiableList(lines);
    }

    public int getSize() {
        return lines.size();
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
