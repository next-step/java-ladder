package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;

public class UserRewardSet {
    private final Users users;
    private final Rewards rewards;

    private static final String NOT_CONTAINS_USER = "없는 유저입니다.";

    public UserRewardSet(final Users users, final Rewards rewards) {
        validation(users, rewards);
        this.users = users;
        this.rewards = rewards;
    }

    private void validation(final Users users, final Rewards rewards) {
        if (users.size() != rewards.size()) {
            throw new IllegalArgumentException(ExceptionMessage.USERS_REWARDS_SIZE_NOT_EQUAL.getMessage());
        }
    }

    public int firstUsernameLength() {
        return users.firstUsernameLength();
    }

    public String rewardString(Positions position, User user) {
        if(!users.contains(user)){
            return NOT_CONTAINS_USER;
        }
        return position.matchString(rewards::rewardString, users.indexOf(user));
    }

    public String userRewardAllString(Positions positions) {
        return positions.matchAllString(users::userString, rewards::rewardString);
    }

}
