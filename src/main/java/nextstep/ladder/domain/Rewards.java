package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rewards {
    private final Map<Integer, String> rewards;

    public Rewards(List<String> rewards) {
        this.rewards = createRewards(rewards);
    }

    private Map<Integer, String> createRewards(List<String> rewards) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < rewards.size(); i++) {
            map.put(i, rewards.get(i));
        }

        return map;
    }

    public String findReward(int position) {
        return rewards.get(position);
    }

    public Map<Integer, String> getRewards() {
        return Collections.unmodifiableMap(rewards);
    }
}
