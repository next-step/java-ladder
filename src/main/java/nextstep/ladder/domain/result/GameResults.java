package nextstep.ladder.domain.result;

import nextstep.ladder.domain.player.Player;

import java.util.Map;

public class GameResults {
    private final Map<Player, Result> results;

    public GameResults(Map<Player, Result> results) {
        assertNotEmpty(results);

        this.results = results;
    }

    private void assertNotEmpty(Map<Player, Result> results) {
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("경기결과는 비어있을 수 없습니다.");
        }
    }

    public void add(Player player, Result result) {
        this.results.put(player, result);
    }

    public Result findBy(Player player) {
        return results.get(player);
    }
}
