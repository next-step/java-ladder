package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.strategy.Strategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> values;

    private Lines(List<Line> values) {
        this.values = values;
    }

    public static Lines from(int height, int numberOfParticipants, Strategy strategy) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(index -> Line.from(numberOfParticipants, strategy))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

    public List<Line> values() {
        return values;
    }

    public int size() {
        return values.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines = (Lines) o;
        return Objects.equals(values, lines.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Lines{" +
                "values=" + values +
                '}';
    }
}
