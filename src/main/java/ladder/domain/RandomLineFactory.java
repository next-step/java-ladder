package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLineFactory implements LineFactory {

    @Override
    public Line create(Integer personCount) {
        List<Boolean> bridges = new ArrayList<>();
        bridges.add(booleanRandomly());
        for (int i = 1; i < personCount - 1; i++) {
            bridges.add(nextBridges(bridges.get(i - 1)));
        }

        return new Line(bridges);
    }

    private Boolean nextBridges(Boolean existsPreviousBridge) {
        if (!existsPreviousBridge) {
            return booleanRandomly();
        }

        return false;
    }

    private boolean booleanRandomly() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
