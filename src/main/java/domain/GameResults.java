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

    public GameResult resultByPlayer(Player player) {
        return gameResults.stream()
                .filter(gameResult -> gameResult.isPlayer(player))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 플레이어의 결과가 없습니다."));
    }
}
