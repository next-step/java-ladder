package laddergame.ladder;

import laddergame.connectable.Connection;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLines {
    private final List<LadderLine> lines;

    public LadderLines(Height height, int countOfPerson, Connection connection) {
        this.lines = IntStream.range(0, height.value())
                .mapToObj(i -> new LadderLine(countOfPerson, connection))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLines that = (LadderLines) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public List<LadderLine> value() {
        return this.lines;
    }
}
