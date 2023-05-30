package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(matchingResult, result.matchingResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchingResult);
    }
}
