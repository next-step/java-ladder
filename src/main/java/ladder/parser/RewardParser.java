package ladder.parser;

import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RewardParser {
    private static final String DELIMETER = ",";

    private RewardParser() {
    }

    public static Rewards parseRewards(String source) {
        List<Reward> rewards = Arrays.stream(source.split(DELIMETER))
                .map(RewardParser::parseReward)
                .collect(Collectors.toList());

        return new Rewards(rewards);
    }

    public static Reward parseReward(String reward) {
        return new Reward(reward.trim());
    }
}
