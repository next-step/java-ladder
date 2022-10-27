package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RowGenerator {

    private List<Boolean> points = new ArrayList<>();
    private int people;

    public RowGenerator(int people) {
        this.people = people;
        this.points = IntStream.range(0, people)
            .mapToObj(i -> false)
            .collect(Collectors.toList());
    }

    public Row create() {
        IntStream.range(1, people)
            .filter(index -> RandomBooleanGenerator.generator())
            .forEach(this::drawLine);
        return Row.from(points);
    }

    private void drawLine(int index) {
        if (points.get(index - 1).equals(false)) {
            points.set(index, true);
        }
    }
}
