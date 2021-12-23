package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStrategy implements Strategy {
    private final List<Boolean> points = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public List<Boolean> points(int numberOfParticipants) {
        points.add(random.nextBoolean());

        for (int i = 1; i < numberOfParticipants; i++) {
            points.add(newPoint(i));
        }

        return points;
    }

    private boolean newPoint(int i) {
        Boolean previousValue = points.get(i - 1);

        if (previousValue) {
            return false;
        }
        return true;
    }
}
