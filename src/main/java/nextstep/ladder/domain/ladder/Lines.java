package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.Condition;
import nextstep.ladder.domain.ladder.strategy.Strategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    public static final int START_VALUE = 0;
    private final List<Line> values;

    private Lines(List<Line> values) {
        this.values = values;
    }

    public static Lines from(Condition condition, Strategy strategy) {
        List<Line> lines = lines(condition, strategy);
        return new Lines(lines);
    }

    public List<Line> values() {
        return values;
    }

    public int size() {
        return values.size();
    }

    private static List<Line> lines(Condition condition, Strategy strategy) {
        int numberOfParticipants = condition.numberOfParticipants();
        int height = condition.heightOfLadder();

        return IntStream.range(START_VALUE, height)
                .mapToObj(index -> Line.from(numberOfParticipants, strategy))
                .collect(Collectors.toList());
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
