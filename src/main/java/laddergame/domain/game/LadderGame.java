package laddergame.domain.game;

import laddergame.domain.game.dto.GameInfoDto;
import laddergame.domain.ladder.BridgeConnectGenerator;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import laddergame.domain.vo.Column;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(final GameInfoDto gameInfoDto, BridgeConnectGenerator connectGenerator) {
        this.ladder = new Ladder(gameInfoDto.getLadderHeight(), gameInfoDto.getPlayers().getNumberOfPlayers(), connectGenerator);
    }

    public GameResult startGame(Players players, Prizes prizes) {
        Map<Player, Prize> results = new HashMap<>();

        for (Player player : players.getPlayers()) {
            Column afterMoveColumn = ladder.progressAllStep(player.getColumn());
            results.put(player, prizes.findByColumn(afterMoveColumn));
        }

        return new GameResult(results);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
