package com.fineroot.ladder.domain;

import com.fineroot.ladder.engine.Positions;

public class LadderGameResult {
    private final UserRewardSet userRewardSet;
    private final Positions positions;

    public LadderGameResult(UserRewardSet userRewardSet, Positions positions) {
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
