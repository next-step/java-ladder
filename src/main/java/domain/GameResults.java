package domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResults implements Iterable<GameResult> {

    private final List<GameResult> gameResults;

    private GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults createResults(Ladder ladder, Players players, Rewards rewards) {
        return new GameResults(IntStream.range(0, players.totalNumber())
                .mapToObj(players::findByOrder)
                .map(player -> GameResult.createResult(ladder, players, rewards, player))
                .collect(Collectors.toList()));
    }

    @Override
    public Iterator<GameResult> iterator() {
        return gameResults.iterator();
    }
}
