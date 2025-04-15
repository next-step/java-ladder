package ladder.domain;

public class GameResult {
    private final Ladder ladder;
    private final Results results;

    public GameResult(Ladder ladder, Results results) {
        this.ladder = ladder;
        this.results = results;
    }

    public String getResultName(int playerIdx) {
        int resultIdx = ladder.findResultIdx(playerIdx);
        return results.getName(resultIdx);
    }
}
