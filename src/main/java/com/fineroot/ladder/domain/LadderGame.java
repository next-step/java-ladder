package com.fineroot.ladder.domain;

public class LadderGame {
    private final Ladder ladder;
    private final UserRewardSet userRewardSet;

    public LadderGame(Ladder ladder, UserRewardSet userRewardSet) {
        this.ladder = ladder;
        this.userRewardSet = userRewardSet;
    }

    public String ladderBoard(){
        return ladder.toStringBoard(userRewardSet.firstUsernameLength());
    }

    public LadderResult ladderResult(){
        return new LadderResult(userRewardSet,ladder.resultAll());
    }
}
