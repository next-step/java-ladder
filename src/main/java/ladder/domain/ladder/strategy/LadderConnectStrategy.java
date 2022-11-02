package ladder.domain.ladder.strategy;

import ladder.domain.ladder.HorizontalLineDirection;

import java.util.List;

public interface LadderConnectStrategy {
    List<HorizontalLineDirection> connectableLadders(HorizontalLineDirection beforeHorizontalLineDirection);

    List<HorizontalLineDirection> firstLadder();

    HorizontalLineDirection lastLadder(HorizontalLineDirection beforeHorizontalLineDirection);

}
