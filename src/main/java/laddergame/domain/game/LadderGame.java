package laddergame.domain.game;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.vo.Column;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(final Ladder ladder) {
        this.ladder = ladder;
    }

    public GameResult startGame(Players players, Prizes prizes) {
        Map<Player, Prize> results = new HashMap<>();

        for (Player player : players.getPlayers()) {
            Column afterMoveColumn = ladder.progressAllStep(player.getColumn());
            results.put(player, prizes.findByColumn(afterMoveColumn));
        }

        return new GameResult(results);
    }
}
