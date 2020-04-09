package ladder.controller;

import ladder.domain.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private LadderGame() { }

    public static Result run(final Players players, final Ladder ladder, final Prizes prizes) {
        Map<Player, Prize> result = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            Position prizePosition = ladder.climbDown(player.startPosition());
            Prize prize = prizes.find(prizePosition);
            result.put(player, prize);
        }
        return new Result(result);
    }
}