package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GameResult implements Iterable<Map.Entry<Player, Reward>> {

    private final Map<Player, Reward> result = new HashMap<>();
    private final Player player;
    private final Reward reward;

    public GameResult(Player player, Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    public void add(Player player, Reward reward) {
        result.put(player, reward);
    }

    public Player getPlayer() {
        return player;
    }

    public Reward getReward() {
        return reward;
    }

    @Override
    public Iterator<Map.Entry<Player, Reward>> iterator() {
        return result.entrySet().iterator();
    }
}
