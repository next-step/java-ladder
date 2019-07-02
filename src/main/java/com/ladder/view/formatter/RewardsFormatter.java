package com.ladder.view.formatter;

import com.ladder.model.Reward;
import com.ladder.model.Rewards;

import java.util.stream.Collectors;

public class RewardsFormatter implements Formatter<Rewards> {

    private final Formatter<Reward> rewardFormatter = new RewardFormatter();

    @Override
    public String format(Rewards rewards) {
        return rewards.getRewards()
                .stream()
                .map(rewardFormatter::format)
                .collect(Collectors.joining());
    }
}