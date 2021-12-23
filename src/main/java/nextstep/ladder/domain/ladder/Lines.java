package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.strategy.RandomStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> values;

    private Lines(List<Line> values) {
        this.values = values;
    }

    public static Lines from(int height, int numberOfParticipants) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(index -> Line.from(numberOfParticipants, new RandomStrategy()))
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
    public String toString() {
        return "Lines{" +
                "values=" + values +
                '}';
    }
}
