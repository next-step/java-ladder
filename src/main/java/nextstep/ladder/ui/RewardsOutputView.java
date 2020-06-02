package nextstep.ladder.ui;

import nextstep.ladder.domain.Rewards;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RewardsOutputView {
    private static final String EMPTY_SPACE = " ";

    private Rewards rewards;

    public RewardsOutputView(Rewards rewards) {
        this.rewards = rewards;
    }

    public String parseRewards(int playerNameMaxLength) {
        return rewards.getRewardNameValues().stream()
                .map(rewardNameValue -> generateNameSpace(playerNameMaxLength, rewardNameValue) + rewardNameValue)
                .collect(Collectors.joining());
    }

    private String generateNameSpace(int playerNameMaxLength, String rewardNameValue) {
        int spaceLength = playerNameMaxLength - rewardNameValue.length() + 1;
        return IntStream.range(0, spaceLength)
                .mapToObj(num -> EMPTY_SPACE)
                .collect(Collectors.joining());
    }
}
