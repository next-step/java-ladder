package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        points.add(0, randomBoolean());
        for (int i = 1; i < countOfPerson - 1; i++) {
            addBooleanValue(i);
        }
    }

    private void addBooleanValue(int index) {
        if (points.get(index - 1).equals(Boolean.TRUE)) {
            points.add(index, Boolean.FALSE);
        }
        if (points.get(index - 1).equals(Boolean.FALSE)) {
            points.add(index, randomBoolean());
        }
    }

    private boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
