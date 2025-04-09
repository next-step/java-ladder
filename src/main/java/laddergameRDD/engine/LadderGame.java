package laddergameRDD.engine;

import laddergameRDD.domain.GameResult;

import java.util.List;

public interface LadderGame {
    public List<GameResult> play(int rowCount, List<String> users, List<String> results);
}
