package laddergame.domain.game;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.vo.Position;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(final Ladder ladder) {
        this.ladder = ladder;
    }

    public GameResult generateGameResult(Players players, Results results) {
        Map<String, Result> resultMap = new HashMap<>();

        for (Player player : players.getPlayers()) {
            Position afterMove = ladder.progressAllStep(player.getPosition());
            resultMap.put(player.getName(), results.findByColumn(afterMove.getColumn()));
        }

        return new GameResult(resultMap);
    }
}
