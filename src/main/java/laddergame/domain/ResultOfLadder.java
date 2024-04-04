package laddergame.domain;

import java.util.Map;
import java.util.Optional;

public class ResultOfLadder {
    private final Map<Player, WinningContent> results;

    private ResultOfLadder(Map<Player, WinningContent> results) {
        this.results = results;
    }

    public static ResultOfLadder valueOf(Map<Player, WinningContent> results) {
        return new ResultOfLadder(results);
    }

    public WinningContent winningContentOfPlayer(Player player) {
        return Optional.ofNullable(results.get(player))
                .orElseThrow(IllegalArgumentException::new);
    }
}
