package nextstep.ladder.Model;

import java.util.List;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public Reward getRewardByLocation(int location) {
        return rewards.get(location);
    }

    public List<Reward> getRewards() {
        return this.rewards;
    }
}
