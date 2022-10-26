package ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row {

    private List<Boolean> points;

    private Row(List<Boolean> points) {
        this.points = points;
    }

    public static Row from(int people) {
        List<Boolean> points = IntStream.range(0, people)
            .mapToObj(i -> false)
            .collect(Collectors.toList());

        return new Row(points);
    }

    public Row generate(int people) {
        IntStream.range(1, people)
            .filter(index -> getRandomBoolean())
            .forEach(this::drawLine);
        return new Row(points);
    }

    private void drawLine(int index) {
        if (points.get(index - 1).equals(false)) {
            points.set(index, true);
        }
    }

    private Boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
