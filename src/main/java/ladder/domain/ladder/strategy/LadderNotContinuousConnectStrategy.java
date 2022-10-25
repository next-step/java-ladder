package ladder.domain.ladder.strategy;

import ladder.domain.ladder.Ladder;
import ladder.exception.NoConnectableLadder;

import java.util.List;

public class LadderNotContinuousConnectStrategy implements LadderConnectStrategy {
    @Override
    public List<Ladder> connectableLadders(Ladder beforeLadder) {
        if (beforeLadder.equals(Ladder.LEFT)) {
            return List.of(Ladder.RIGHT, Ladder.NONE);
        }
        if (beforeLadder.equals(Ladder.RIGHT)) {
            return List.of(Ladder.LEFT);
        }
        if (beforeLadder.equals(Ladder.NONE)) {
            return List.of(Ladder.RIGHT, Ladder.NONE);
        }
        throw new NoConnectableLadder();
    }
}
