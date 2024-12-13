package ladder.domain.impl;

import ladder.domain.engine.Rewards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RewardsImpl implements Rewards {

    private final List<String> rewards;

    private RewardsImpl(List<String> rewards) {
        this.rewards = new ArrayList<>(rewards);
    }

    public static Rewards of(List<String> rewards) {
        return new RewardsImpl(rewards);
    }

    @Override
    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    @Override
    public String get(int index) {
        return rewards.get(index);
    }
}
