package com.fineroot.ladder.domain;

public class LadderResult {
    private UserRewardSet userRewardSet;
    private Positions positions;

    public LadderResult(UserRewardSet userRewardSet, Positions positions) {
        this.userRewardSet = userRewardSet;
        this.positions = positions;
    }

    public String resultSting(User user) {
        if (user.isAll()) {
            return userRewardSet.userRewardAllString(positions);
        }
        return userRewardSet.rewardString(positions, user);
    }
}
