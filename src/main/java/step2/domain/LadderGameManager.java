package step2.domain;

import java.util.List;

public class LadderGameManager {
    private final LadderGameColumns ladderGameColumns;
    private final Results results;

    public LadderGameManager(Name name, Results results) {
        ladderGameColumns = new LadderGameColumns(name);
        this.results = results;
    }

    public List<LadderGameColumn> getLadderResults() {
        return ladderGameColumns.getLadderGameList();
    }

    public void runGame(int height, Ladder ladder) {
        ladderGameColumns.runLadder(height, ladder);
        ladderGameColumns.calculateResult(results);
    }
}