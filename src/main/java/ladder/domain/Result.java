package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private final Map<Player, Prize> matchingResult;

    public Result() {
        this.matchingResult = new LinkedHashMap<Player, Prize>();
    }

    public Map<Player, Prize> getMatchingResult() {
        return Collections.unmodifiableMap(matchingResult);
    }

    public void put(Player player, Prize prize) {
        matchingResult.put(player, prize);
    }

    public String searchPlayer(String playerName) {
        return matchingResult.entrySet().stream()
                .filter(entry -> entry.getKey().isNameEqual(playerName))
                .map(entry -> entry.getValue().getName())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No prize found for player: " + playerName));
    }
}
