package ladder.domain.ladder;

import ladder.domain.util.RandomBooleanGenerator;

public class RandomLadderFactory extends LadderFactory{
    @Override
    public RandomLadder createLadder(int height, int intervalCount) {
        return new RandomLadder(height, intervalCount, new RandomBooleanGenerator()).makeLadder();
    }
}
