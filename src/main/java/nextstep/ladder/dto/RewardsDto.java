package nextstep.ladder.dto;

import java.util.List;

public class RewardsDto {

    private final List<RewardDto> rewards;

    public RewardsDto(List<RewardDto> rewards) {
        this.rewards = rewards;
    }

    public List<RewardDto> getRewards() {
        return rewards;
    }
}
