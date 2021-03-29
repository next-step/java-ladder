package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int MIN_PERSON = 2;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final boolean NON_LINE = false;
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        if (countOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException();
        }

        IntStream.range(0, countOfPerson)
                .forEach(index -> points.add(NON_LINE));
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public void draw(DrawStrategy drawStrategy) {
        points.set(FIRST_INDEX, drawStrategy.drawValue());
        IntStream.range(1, points.size() - 1)
                .forEach(index -> update(index, drawStrategy.drawValue()));
    }

    private void update(int index, boolean isLine) {
        if (isValidate(Arrays.asList(points.get(index - 1), isLine))) {
            points.set(index, isLine);
        }
    }

    private boolean isValidate(List<Boolean> points) {
        return !points.get(FIRST_INDEX) || !points.get(SECOND_INDEX);
    }
}
