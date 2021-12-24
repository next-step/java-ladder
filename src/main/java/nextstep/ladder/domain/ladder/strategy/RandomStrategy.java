package nextstep.ladder.domain.ladder.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStrategy implements Strategy {
    private final Random random = new Random();

    @Override
    public List<Boolean> points(int numberOfParticipants) {
        List<Boolean> points = new ArrayList<>();
        points.add(random.nextBoolean());

        for (int i = 1; i < numberOfParticipants - 1; i++) {
            points.add(newPoint(points, i));
        }

        return points;
    }

    private boolean newPoint(List<Boolean> points, int i) {
        Boolean previousValue = points.get(i - 1);

        if (previousValue) {
            return false;
        }
        return true;
    }
}
