package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RANDOM = new Random();
    private final List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(createRandomPoint(i));
        }
    }

    public Line (int countOfPerson, List<Boolean> points) {
        this.points.addAll(points);
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
    }

    private boolean createRandomPoint(int index) {
        if (index > 0 && points.get(index - 1)) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
