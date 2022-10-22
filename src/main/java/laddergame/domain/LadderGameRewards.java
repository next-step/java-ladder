package laddergame.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGameRewards {

    private final List<LadderGameReward> rewards;

    public LadderGameRewards(List<LadderGameReward> rewards) {
        this.rewards = rewards;
    }

    public static LadderGameRewards from(List<String> rewardValues) {
        List<LadderGameReward> rewards = rewardValues.stream()
                .map(LadderGameReward::new)
                .collect(Collectors.toList());
        return new LadderGameRewards(rewards);
    }

    public LadderGameReward get(int index) {
        return rewards.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameRewards that = (LadderGameRewards) o;
        return Objects.equals(rewards, that.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }

    @Override
    public String toString() {
        return "LadderGameRewards{" +
                "rewards=" + rewards +
                '}';
    }

}
