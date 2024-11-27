package ladder.domain;

import java.util.Objects;

public class Reward {
    private final RewardName rewardName;
    private final X x;

    public Reward(RewardName rewardName, X x) {
        this.rewardName = rewardName;
        this.x = x;
    }

    public Reward(String name, int x) {
        this(new RewardName(name), new X(x));
    }

    public RewardName name() {
        return rewardName;
    }

    public boolean isEqualPosition(Player player) {
        return player.position().xEquals(this.x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(rewardName, reward.rewardName) && Objects.equals(x, reward.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardName, x);
    }
}
