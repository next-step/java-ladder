package ladder.domain.ladder.strategy;

import ladder.domain.ladder.HorizontalLineDirection;
import ladder.exception.ladder.NoConnectableHorizontalLineDirectionException;

import java.util.List;

public class LadderNotContinuousConnectStrategy implements LadderConnectStrategy {
    @Override
    public List<HorizontalLineDirection> connectableLadders(HorizontalLineDirection beforeHorizontalLineDirection) {
        if (beforeHorizontalLineDirection.equals(HorizontalLineDirection.LEFT)) {
            return List.of(HorizontalLineDirection.RIGHT, HorizontalLineDirection.NONE);
        }
        if (beforeHorizontalLineDirection.equals(HorizontalLineDirection.RIGHT)) {
            return List.of(HorizontalLineDirection.LEFT);
        }
        if (beforeHorizontalLineDirection.equals(HorizontalLineDirection.NONE)) {
            return List.of(HorizontalLineDirection.RIGHT, HorizontalLineDirection.NONE);
        }
        throw new NoConnectableHorizontalLineDirectionException();
    }

    @Override
    public HorizontalLineDirection lastLadder(HorizontalLineDirection beforeHorizontalLineDirection) {
        if (beforeHorizontalLineDirection.equals(HorizontalLineDirection.LEFT) || beforeHorizontalLineDirection.equals(HorizontalLineDirection.NONE)) {
            return HorizontalLineDirection.NONE;
        }
        if(beforeHorizontalLineDirection.equals(HorizontalLineDirection.RIGHT)){
            return HorizontalLineDirection.LEFT;
        }
        throw new NoConnectableHorizontalLineDirectionException();
    }
}
