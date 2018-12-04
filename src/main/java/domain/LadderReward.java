package domain;

import java.util.Optional;

import static java.util.Optional.ofNullable;

public class LadderReward {

    private final Rewards rewards;

    public LadderReward(final String reward, final Players players) {

        ofNullable(reward).orElseThrow(IllegalArgumentException::new);
        Optional.of(reward).filter(r -> !r.isEmpty()).orElseThrow(IllegalArgumentException::new);
        rewards = new Rewards(reward.split(","));

        if (this.rewardsSize() != players.size() + 1) {
            throw new IllegalArgumentException();
        }

    }

    public int rewardsSize() {
        return this.rewards.size();
    }

    public String findReward(final int playerNo) {
        return this.rewards.findReward(playerNo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(rewards.toString());
        return sb.toString();
    }
}
