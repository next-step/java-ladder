package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.RandomBooleanGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Points> rows;

    public Lines(List<Points> rows) {
        this.rows = rows;
    }

    public static Lines create(int lineSize, int pointSize) {
        return new Lines(
                IntStream.range(0, lineSize)
                        .mapToObj(index -> Points.initialize(pointSize - 1, new RandomBooleanGenerator()))
                        .collect(Collectors.toUnmodifiableList()));
    }

    public List<Points> getRows() {
        return rows;
    }

    public int size() {
        return rows.size();
    }

    @Override
    public String toString() {
        return "LineColumns{" +
                "rows=" + rows +
                '}';
    }
}
