package ladder.domain;

import java.util.HashMap;

public class Result {
    private HashMap<Player, Prize> matchingResult;

    public Result() {
        this.matchingResult = new HashMap<Player, Prize>();
    }

    public void put(Player player, Prize prize) {
        matchingResult.put(player, prize);
    }

    public String searchPlayer(String playerName) {
        return matchingResult.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(playerName))
                .map(entry -> entry.getValue().getName())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No prize found for player: " + playerName));
    }
}
