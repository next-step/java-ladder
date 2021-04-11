package nextstep.ladder.dto;

import java.util.List;

public class RewardsDto {

    private final List<String> rewards;

    public RewardsDto(List<String> rewards) {
        this.rewards = rewards;
    }

    public List<String> getRewards() {
        return rewards;
    }
}
