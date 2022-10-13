package ladder.domain.v2;

import ladder.domain.factory.ILine;
import ladder.domain.factory.LineFactory;
import ladder.external.RandomFactory;

public class RandomLadderLineFactory implements LineFactory {
    private final RandomFactory randomFactory;

    public RandomLadderLineFactory(RandomFactory randomFactory) {
        this.randomFactory = randomFactory;
    }

    @Override
    public ILine create(int playerCount) {
        return LadderLine.init(playerCount, randomFactory);
    }
}
