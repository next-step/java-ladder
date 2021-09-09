package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private static final Random RANDOM = new Random();

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int countOfPerson) {
        points.add(RANDOM.nextBoolean());
        for (int i = 1; i < countOfPerson - 1; i++) {
            addPoint(i);
        }
    }

    private void addPoint(int currentIndex) {
        int previouseIndex = currentIndex - 1;
        if (points.get(previouseIndex)) {
            points.add(Boolean.FALSE);
            return;
        }
        points.add(RANDOM.nextBoolean());
        return;
    }

    public List<Boolean> getPoints() {
        return points;
    }


}