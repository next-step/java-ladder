package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    public static final Random random = new Random();

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPersons) {
        if (countOfPersons <= 1) {
            return;
        }
        points.add(random.nextBoolean());

        for (int i = 1; i < countOfPersons - 1; i++) {
            addPoint(i);
        }
    }

    @Override public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

    public int getCount() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void addPoint(int index) {
        if (addFalseIfBeforeTrue(index)) return;
        points.add(random.nextBoolean());
    }

    private boolean addFalseIfBeforeTrue(int index) {
        if (points.get(index - 1)) {
            points.add(false);
            return true;
        }
        return false;
    }
}
