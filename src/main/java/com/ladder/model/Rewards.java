package com.ladder.model;

import com.ladder.exception.RewardsLessMinimumException;
import com.ladder.utils.AssertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Rewards {

    public static final int MIN_NUMBER_OF_REWARDS = 2;
    private static final String SEPARATOR_OF_NAMES = ",";

    private List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = new ArrayList<>(rewards);
    }

    public static Rewards of(String inputOfRewardNames) {
        AssertUtils.checkNull(inputOfRewardNames);

        String[] rewards = inputOfRewardNames.split(SEPARATOR_OF_NAMES);
        if (rewards.length < MIN_NUMBER_OF_REWARDS) {
            throw new RewardsLessMinimumException();
        }

        return Arrays.stream(rewards)
                .map(Reward::of)
                .collect(collectingAndThen(toList(), Rewards::new));
    }

    int countOfRewards() {
        return rewards.size();
    }

    Reward findByPosition(Position position) {
        return rewards.get(position.getPosition());
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
