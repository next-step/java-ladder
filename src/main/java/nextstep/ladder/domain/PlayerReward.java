package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PlayerReward {

    private final Map<Player, Reward> playerReward;

    public PlayerReward() {
        this.playerReward = new HashMap<>();
    }

    public void put(Player player, Reward reward) {
        this.playerReward.put(player, reward);
    }

    public Reward get(Player player) {
        return this.playerReward.get(player);
    }

    public int count() {
        return this.playerReward.size();
    }

    public Map<Player, Reward> toMap() {
        return Collections.unmodifiableMap(this.playerReward);
    }
}
