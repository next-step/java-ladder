package ladder.domain;

import java.util.*;

public class LineRandomGenerator {
    private static final Random random = new Random();
    private Participants participant;

    public LineRandomGenerator(Participants participant) {
        this.participant = participant;
    }

    private boolean getRandom() {
        return random.nextBoolean();
    }

    public Line create() {
        List<Points> points;
        if (participant.isShortage()) {
            points = Collections.singletonList(Points.getFirst(false));
            return Line.of(points);
        }

        points = makeRandomPoints();

        return Line.of(points);
    }

    private List<Points> makeRandomPoints() {
        List<Points> points = new ArrayList<>();
        points.add(Points.getFirst(getRandom()));

        for (int i = 0; i < participantCount - 2; i++) {
            Points old = points.get(i);
            Points next = Points.next(old, getRandom());

            points.add(next);
        }
        Points last = Points.getLast(points.get(participantCount - 2).isRight());
        points.add(last);

        return points;
    }

}
