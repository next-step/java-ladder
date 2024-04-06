package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GameResult implements Iterable<Map.Entry<Player, Reward>> {

    private final Map<Player, Reward> result = new HashMap<>();

    public void add(Player player, Reward reward) {
        result.put(player, reward);
    }

    @Override
    public Iterator<Map.Entry<Player, Reward>> iterator() {
        return result.entrySet().iterator();
    }
}
