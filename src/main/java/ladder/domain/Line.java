package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private static final int MIN_PERSON = 2;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final Random random = new Random();
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        if (countOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < countOfPerson; i++) {
            points.add(Boolean.FALSE);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public void draw() {
        points.set(FIRST_INDEX, random.nextBoolean());
        IntStream.range(1, points.size() - 1)
                .forEach(this::update);
    }

    public void update(int i) {
        boolean isLine = random.nextBoolean();
        if (isValidate(Arrays.asList(points.get(i - 1), isLine))) {
            points.set(i, isLine);
        }
    }

    public boolean isValidate(List<Boolean> points) {
        return !points.get(FIRST_INDEX) || !points.get(SECOND_INDEX);
    }
}
