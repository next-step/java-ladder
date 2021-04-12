package nextstep.ladder.view.dto;

import nextstep.ladder.domain.Reward;

public class RewardDto {

    private static final String REWARD_RESULT_FORMAT = "%s : %s";

    private String name;
    private String reward;

    public RewardDto(String name, Reward reward) {
        this.name = name;
        this.reward = reward.getReward();
    }

    public String reward() {
        return String.format(REWARD_RESULT_FORMAT, this.name, this.reward);
    }

    public String getName() {
        return this.name;
    }

    public String getReward() {
        return reward;
    }
}
