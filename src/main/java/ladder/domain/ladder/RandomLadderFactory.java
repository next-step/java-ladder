package ladder.domain.ladder;

import ladder.domain.Ladder;
import ladder.domain.util.RandomBooleanGenerator;

public class RandomLadderFactory extends LadderFactory{
    @Override
    public Ladder createLadder(int height, int intervalCount) {
        return new Ladder(height, intervalCount, new RandomBooleanGenerator()).makeLadder();
    }
}
