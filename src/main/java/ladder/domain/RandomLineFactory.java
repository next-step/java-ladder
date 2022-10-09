package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLineFactory implements LineFactory {

    @Override
    public Line create(Integer personCount) {
        List<Boolean> horizontalWays = new ArrayList<>();
        horizontalWays.add(booleanRandomly());
        for (int i = 1; i < personCount - 1; i++) {
            horizontalWays.add(nextHorizontalWay(horizontalWays.get(i - 1)));
        }

        return new Line(horizontalWays);
    }

    private Boolean nextHorizontalWay(boolean existsPreviousHorizontalWay) {
        if (!existsPreviousHorizontalWay) {
            return booleanRandomly();
        }

        return false;
    }

    private boolean booleanRandomly() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
