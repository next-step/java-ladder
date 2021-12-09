package domain;

import java.util.List;

public class LadderResult {
    private final List<String> gameResults;

    public LadderResult(List<String> ladderResult) {
        gameResults = ladderResult;
    }

    public String result(int point) {
        return gameResults.get(point);
    }
}
