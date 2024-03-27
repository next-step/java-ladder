package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(final int numberOfPeople) {
        final Random random = new Random();
        for (int i = 0; i < numberOfPeople - 1; i++) {
            points.add(random.nextBoolean());
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
