package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RANDOM = new Random();
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        points.add(createRandomBoolean());
        for (int i = 1; i < countOfPerson-1; i++) {
            if (points.get(i-1)) {
                points.add(false);
                continue;
            }
            points.add(createRandomBoolean());
        }
    }

    private boolean createRandomBoolean() {
        return RANDOM.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
