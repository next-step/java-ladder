package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LineRandomGenerator {
    private static final Random random = new Random();
    private int participantCount;

    public LineRandomGenerator(int participantCount) {
        this.participantCount = participantCount;
    }

    private boolean getRandom() {
        return random.nextBoolean();
    }

    public Line create() {
        List<Points> points = new ArrayList<>();

        if (participantCount <= 1) {
            return Line.of(Arrays.asList(Points.getFirst(false)));
        }

        points.add(Points.getFirst(getRandom()));
        for (int i = 0; i < participantCount - 2; i++) {
            Points old = points.get(i);
            Points next = Points.next(old, getRandom());

            points.add(next);
        }
        Points last = Points.getLast(points.get(participantCount - 2).isRight());
        points.add(last);

        return Line.of(points);
    }

}
