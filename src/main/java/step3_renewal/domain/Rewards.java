package step3_renewal.domain;

import step3_renewal.exception.NotMatchException;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<String> rewards, int sizeOfPersonal) {
        validate(rewards, sizeOfPersonal);
        return new Rewards(toReward(rewards));
    }

    public static List<Reward> toReward(List<String> reward) {
        return reward.stream()
                .map(Reward::of)
                .collect(Collectors.toList());
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public String getRewardName(int position) {
        return rewards.get(position).getName();
    }

    private static void validate(List<String> rewards, int sizeOfPersonal) {
        int sizeOfReward = rewards.size();
        if(sizeOfReward != sizeOfPersonal) {
            throw new NotMatchException(sizeOfPersonal, sizeOfReward);
        }
    }
}
