package ladder.domain.line.v2;

import ladder.domain.line.ILine;
import ladder.domain.line.LineFactory;
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
