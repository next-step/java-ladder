package ladder.domain.ladder.strategy;

import ladder.domain.ladder.Ladder;

import java.util.List;

public interface LadderConnectStrategy {
    List<Ladder> connectableLadders(Ladder beforeLadder);
}
