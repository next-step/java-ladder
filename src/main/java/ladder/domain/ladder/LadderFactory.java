package ladder.domain.ladder;

import ladder.domain.RandomLadder;

public abstract class LadderFactory {
    public abstract RandomLadder createLadder(int height, int intervalCount);
}
