package domain;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResults implements Iterable<GameResult> {

    private final Map<Player, GameResult> gameResults;

    private GameResults(Map<Player, GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults createResults(Ladder ladder, Players players, Rewards rewards) {
        return new GameResults(IntStream.range(0, players.totalNumber())
                .mapToObj(players::findByOrder)
                .collect(Collectors.toMap(
                        player -> player,
                        player -> GameResult.createResult(ladder, players, rewards, player)
                )));
    }

    public GameResult resultByPlayer(Player player) {
        if (!gameResults.containsKey(player)) {
            throw new IllegalArgumentException("해당 플레이어의 결과가 없습니다.");
        }
        return gameResults.get(player);
    }

    @Override
    public Iterator<GameResult> iterator() {
        return gameResults.values().iterator();
    }
}
