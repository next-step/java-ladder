package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        if (countOfPerson < 2) {
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
        Random random = new Random();

        points.set(0, random.nextBoolean());
        for (int i = 1; i < points.size() - 1; i++) {
            boolean isLine = random.nextBoolean();
            if (isValidate(Arrays.asList(points.get(i - 1), isLine))) {
                points.set(i, isLine);
            }
        }
    }

    public boolean isValidate(List<Boolean> points) {
        return !points.get(0) || !points.get(1);
    }
}
