package com.hskim.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final String INVALID_REWARDS_SIZE = "유저수 와 보상수가 일치하지 않습니다.";

    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards, LadderUsers ladderUsers) {
        validateSize(rewards, ladderUsers);
        this.rewards = rewards;
    }

    private void validateSize(List<Reward> rewards, LadderUsers ladderUsers) {
        if (!ladderUsers.isEqualSize(rewards.size())) {
            throw new IllegalArgumentException(INVALID_REWARDS_SIZE);
        }
    }

    public List<String> getAllRewardNames() {
        return rewards.stream()
                .map(Reward::getName)
                .collect(Collectors.toList());
    }
}
