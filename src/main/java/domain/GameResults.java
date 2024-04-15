package domain;

import java.util.Iterator;
import java.util.List;

public class GameResults implements Iterable<GameResult> {

    private final List<GameResult> gameResults;

    public GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    @Override
    public Iterator<GameResult> iterator() {
        return gameResults.iterator();
    }
}
