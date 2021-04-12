package nextstep.ladder.view.dto;

import nextstep.ladder.domain.Query;
import nextstep.ladder.domain.Rewards;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RewardsDto {

    private static final String ILLEGAL_QUERY_MESSAGE = "없는 참가자입니다";

    private List<RewardDto> rewards;

    private RewardsDto(List<RewardDto> rewards) {
        this.rewards = rewards;
    }

    public static RewardsDto of(List<String> players, Rewards reArrangeRewards) {
        return IntStream.range(0, players.size())
                .mapToObj(idx -> new RewardDto(players.get(idx), reArrangeRewards.positionOfReward(idx)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), RewardsDto::new));
    }

    public List<String> readRewards() {
        return rewards.stream()
                .map(RewardDto::reward)
                .collect(Collectors.toUnmodifiableList());
    }

    public RewardDto findQueryResult(Query query) {
        return rewards.stream()
                .filter(rewardDto -> rewardDto.getName().equals(query.query()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ILLEGAL_QUERY_MESSAGE));
    }
}
