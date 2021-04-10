package nextstep.ladder.view.dto;

import nextstep.ladder.domain.Rewards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RewardsDto {

    private List<RewardDto> rewards;

    private RewardsDto(List<RewardDto> rewards) {
        this.rewards = rewards;
    }

    public static RewardsDto of(List<String> players, Rewards reArrangeRewards) {
        List<RewardDto> rewardDtoList = new ArrayList<>();
        for (int idx = 0; idx < players.size(); idx++) {
            rewardDtoList.add(new RewardDto(players.get(idx), reArrangeRewards.positionOfReward(idx)));
        }
        return new RewardsDto(rewardDtoList);
    }

    public List<String> readRewards() {
        return rewards.stream()
                .map(RewardDto::reward)
                .collect(Collectors.toUnmodifiableList());
    }
}
