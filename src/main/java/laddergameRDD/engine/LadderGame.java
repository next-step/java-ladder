package laddergameRDD.engine;

import laddergameRDD.domain.GameResult;
import laddergameRDD.domain.Ladder;

import java.util.List;

public interface LadderGame {
    public List<GameResult> play(Ladder ladder, List<String> users, List<String> results);
}
