package nextstep.ladders.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {

    private final Random random = new Random();
    private final List<Boolean> points;

    public Line(final int countOfPerson) {
        this.points = dot(countOfPerson);
    }

    private List<Boolean> dot(final int countOfPerson) {
        List<Boolean> points = new ArrayList<>(Collections.singletonList(false));
        for (int i = 1; i < countOfPerson; i++) {
            boolean previous = points.get(i - 1);
            boolean next = next(previous);
            points.add(next);
        }
        return points;
    }

    private boolean next(final boolean previous) {
        boolean next = false;
        if (!previous) {
            next = random.nextBoolean();
        }
        return next;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}