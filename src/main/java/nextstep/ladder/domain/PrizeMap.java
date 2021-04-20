package nextstep.ladder.domain;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PrizeMap {
    private final Map<Player, String> prizeMap;

    public PrizeMap() {
        prizeMap = new LinkedHashMap<>();
    }

    public String get(Player player) {
        return prizeMap.get(player);
    }

    public void put(Player player, String prize) {
        prizeMap.put(player, prize);
    }

    public Set<Player> keySet() {
        return prizeMap.keySet();
    }

    public Collection<String> values() {
        return prizeMap.values();
    }

    public int size() {
        return prizeMap.size();
    }
}
