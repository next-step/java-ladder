package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResults {
    private final Map<Player, BetItem> result;

    public GameResults(Map<Player, BetItem> result) {
        this.result = result;
    }

    public List<Player> match(String selectedPlayer) {
        return result.keySet().stream()
                .filter(player -> player.isEqualName(selectedPlayer))
                .collect(Collectors.toList());
    }

    public BetItem find(Player player) {
        return result.get(player);
    }

    public Map<Player, BetItem> getResult() {
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        result.forEach((key, value) -> sb.append(key.getName())
                .append(" : ")
                .append(value.getName())
                .append("\n"));
        return sb.toString();
    }
}
