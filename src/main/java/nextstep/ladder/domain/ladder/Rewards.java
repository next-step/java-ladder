package nextstep.ladder.domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Rewards {

    private final List<Reward> rewards;

    public Rewards(String rewards) {
        this(Arrays.stream(validateReward(rewards).split(","))
                .map(Reward::new)
                .toList());
    }

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static String validateReward(String reward) {
        if (Objects.isNull(reward) || reward.isBlank()) {
            throw new IllegalArgumentException("결과 입력은 필수입니다.");
        }
        return reward;
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
