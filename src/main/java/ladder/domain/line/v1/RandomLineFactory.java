package ladder.domain.line.v1;

import ladder.domain.line.ILine;
import ladder.domain.line.LineFactory;
import ladder.external.RandomFactory;

import java.util.ArrayList;
import java.util.List;

public class RandomLineFactory implements LineFactory {
    private final RandomFactory randomFactory;

    public RandomLineFactory(RandomFactory randomFactory) {
        this.randomFactory = randomFactory;
    }

    @Override
    public ILine create(int playerCount) {
        List<Boolean> bridges = new ArrayList<>();
        bridges.add(randomFactory.nextBoolean());
        for (int i = 1; i < playerCount - 1; i++) {
            bridges.add(nextBridges(bridges.get(i - 1)));
        }

        return new Line(bridges);
    }

    private boolean nextBridges(Boolean existsPreviousBridge) {
        if (!existsPreviousBridge) {
            return randomFactory.nextBoolean();
        }

        return false;
    }
}
