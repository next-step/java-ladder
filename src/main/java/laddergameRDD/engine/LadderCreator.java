package laddergameRDD.engine;

import laddergameRDD.domain.Ladder;

public interface LadderCreator {
    public Ladder createLadder(int rowCount, int columnCount, SelectStrategy selectStrategy);
}
