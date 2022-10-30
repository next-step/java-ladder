package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RowGenerator {

    public RowGenerator() {
    }

    public Row create(int people) {
        List<Boolean> points = IntStream.range(0, people)
            .mapToObj(i -> false)
            .collect(Collectors.toList());

        IntStream.range(0, people-1)
            .filter(index -> RandomBooleanGenerator.generator())
            .filter(i -> points.get(i+1).equals(false))
            .forEach(i-> points.set(i, true));
        return Row.from(points);
    }
}
