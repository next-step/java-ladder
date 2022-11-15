package laddergame.util;

import laddergame.domain.Name;
import laddergame.domain.Player;
import laddergame.domain.Players;
import laddergame.domain.Result;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
    private Mapper() {
    }

    public static Map<Name, Result> toMap(Players players) {
        Map<Name, Result> result = new HashMap<>();
        for (Player player : players.getPlayers()) {
            result.put(player.getName(), player.getResult());
        }
        return result;
    }
}
