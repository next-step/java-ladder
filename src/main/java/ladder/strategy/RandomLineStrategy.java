package ladder.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
    private static final Random RANDOM = new Random();
    private static final int START_INDEX = 1;
    private static final int GO_TO_PREVIOUS_INDEX = -1;

    @Override
    public List<Boolean> initialPoints(int countOfParticipants) {
        List<Boolean> points = new ArrayList<>(Collections.nCopies(countOfParticipants, false));

        for (int index = START_INDEX; index < countOfParticipants; index++) {
            boolean previousPoint = points.get(index + GO_TO_PREVIOUS_INDEX);
            points.set(index, nextPoint(previousPoint));
        }

        return points;
    }

    private static boolean nextPoint(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
