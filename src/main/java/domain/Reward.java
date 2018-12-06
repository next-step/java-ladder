package domain;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

public class Reward {

    private final Results results;

    public Reward(final String reward, final Players players) {

        ofNullable(reward).orElseThrow(IllegalArgumentException::new);
        of(reward).filter(r -> !r.isEmpty()).orElseThrow(IllegalArgumentException::new);
        results = new Results(reward.split(","));

        if (this.rewardsSize() != players.size()) {
            throw new IllegalArgumentException();
        }

    }

    public int rewardsSize() {
        return this.results.size();
    }

    public String findReward(final int playerNo) {
        return this.results.findReward(playerNo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(results.toString());
        return sb.toString();
    }

}
