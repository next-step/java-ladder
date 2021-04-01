package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int MIN_PERSON = 2;
    private static final int FIRST_INDEX = 0;
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        if (countOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException();
        }

        IntStream.range(0, countOfPerson)
                .forEach(index -> points.add(new Point()));
    }

    public List<Point> getPoints() {
        return points;
    }

    public void draw(DrawStrategy drawStrategy) {
        points.set(FIRST_INDEX, new Point(drawStrategy.drawValue()));
        IntStream.range(1, points.size() - 1)
                .forEach(index -> update(index, drawStrategy.drawValue()));
    }

    private void update(int index, boolean isLine) {
        if (points.get(index - 1).isValidate(isLine)) {
            points.set(index, new Point(isLine));
        }
    }

    public int result(int index) {
        if (points.get(index).isPoint()) {
            return  1;
        }
        if (index != 0 && points.get(index - 1).isPoint()) {
            return  - 1;
        }
        return 0;
    }
}
