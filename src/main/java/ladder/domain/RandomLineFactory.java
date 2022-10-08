package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLineFactory implements LineFactory {

    @Override
    public Line create(Integer laneCount) {
        List<Boolean> newLanes = new ArrayList<>();
        newLanes.add(booleanRandomly());
        for (int i = 1; i < laneCount; i++) {
            newLanes.add(nextLane(newLanes, i));
        }

        return new Line(newLanes);
    }

    private Boolean nextLane(List<Boolean> newLanes, int i) {
        if (!newLanes.get(i - 1)) {
            return booleanRandomly();
        }

        return false;
    }

    private boolean booleanRandomly() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
