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

    public static RewardsDto of(PlayerNamesDto players, Rewards reArrangeRewards) {
        List<RewardDto> rewardDtoList = new ArrayList<>();
        List<String> playerNames = players.names();
        for (int idx = 0; idx < playerNames.size(); idx++) {
            rewardDtoList.add(new RewardDto(playerNames.get(idx), reArrangeRewards.positionOfReward(idx)));
        }
        return new RewardsDto(rewardDtoList);
    }

    public List<String> readRewards() {
        return rewards.stream()
                .map(RewardDto::reward)
                .collect(Collectors.toUnmodifiableList());
    }
}
