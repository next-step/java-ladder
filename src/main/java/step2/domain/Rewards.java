package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards {
    private static final String COMMA = ",";

    private final List<Reward> rewards = new ArrayList<>();

    private Rewards(String[] rewards) {
        for (String reward : rewards) {
            this.rewards.add(Reward.of(reward));
        }
    }

    public static Rewards of(String rewards) {
        return new Rewards(split(rewards));
    }

    public Reward getBy(int position) {
        validatePosition(position);
        return rewards.get(position);
    }

    public List<String> getRewardsName() {
        return rewards.stream()
                .map(Reward::getReward)
                .collect(Collectors.toList());
    }

    private void validatePosition(int position) {
        if (rewards.size() <= position) {
            throw new IllegalArgumentException("보상이 존재하지 않습니다.");
        }
    }

    private static String[] split(String rewards) {
        return rewards.split(COMMA);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards1 = (Rewards) o;
        return Objects.equals(rewards, rewards1.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }

    public int size() {
        return rewards.size();
    }
}
