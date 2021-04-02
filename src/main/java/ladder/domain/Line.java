package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int MIN_PERSON = 2;
    private static final boolean LINE = true;
    private static final boolean NON_LINE = false;
    private final int countOfPerson;
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        if (countOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException();
        }
        this.countOfPerson = countOfPerson;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void draw(DrawStrategy drawStrategy) {
        points.add(new Point(drawStrategy.drawValue()));
        IntStream.range(0, countOfPerson - 2)
                .forEach(index -> update(index, drawStrategy.drawValue()));
        points.add(new Point(points.get(countOfPerson - 2).isPoint(), NON_LINE));
    }

    private void update(int index, boolean isLine) {
        if (points.get(index).isValidate(isLine)) {
            points.add(new Point(points.get(index).isPoint(), isLine));
            return;
        }
        points.add(new Point(LINE, NON_LINE));
    }

    public Direction result(int index) {
        return points.get(index).direction();
    }
}
