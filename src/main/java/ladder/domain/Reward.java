package ladder.domain;

import java.util.Objects;

public class Reward {
    private final RewardName rewardName;
    private final Position position;

    public Reward(RewardName rewardName, Position position) {
        this.rewardName = rewardName;
        this.position = position;
    }

    public Reward(String name, int x, int y) {
        this(new RewardName(name), new Position(x, y));
    }

    public RewardName name() {
        return rewardName;
    }

    public boolean isEqualPosition(Player player) {
        return this.position.equals(player.position());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(rewardName, reward.rewardName) && Objects.equals(position, reward.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardName, position);
    }
}
