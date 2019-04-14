package ladder.support;

import ladder.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FixedGameResults {

    public static GameResults ofPlayersAndBetItems(Players p, BetItems b) {
        List<Player> players = p.getPlayers();
        List<BetItem> betItems = b.getBetItems();

        Map<Player, BetItem> result = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            result.put(players.get(i), betItems.get(i));
        }
        return new GameResults(result);
    }
}
