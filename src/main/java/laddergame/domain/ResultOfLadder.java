package laddergame.domain;

import java.util.Map;
import java.util.Optional;

public class ResultOfLadder {
    private final Map<Player, WinningContent> results;

    public ResultOfLadder(Map<Player, WinningContent> results) {
        this.results = results;
    }

    public Optional<WinningContent> winningContentOfPlayer(Player player) {
        return Optional.ofNullable(results.get(player));
    }
}
