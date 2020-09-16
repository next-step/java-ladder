package nextstep.ladder.domain;

import nextstep.ladder.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static nextstep.ladder.constant.ExceptionMessage.INVALID_JOIN_USERS_MINIMIM_SIZE;

public class Rewards {

    private static final int MINIMUM_REWARD_COUNT = 2;

    private List<Reward> rewards;

    private Rewards(List<Reward> rewards) {
        this.rewards = rewards;

        if (rewards.size() < MINIMUM_REWARD_COUNT) {
            throw new IllegalArgumentException(INVALID_JOIN_USERS_MINIMIM_SIZE);
        }
    }

    public static Rewards create(String rewards) {
        String[] splitRewards = StringUtils.split(rewards);

        List<Reward> rewardCollections = Arrays.asList(splitRewards).stream()
                .map(Reward::create)
                .collect(Collectors.toList());

        return new Rewards(rewardCollections);
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    public Reward getReward(int index) {
        return rewards.get(index);
    }
}
