package com.fineroot.ladder.domain;

import com.fineroot.ladder.engine.Ladder;

public class LadderGame {
    private final Ladder ladder;
    private final UserRewardSet userRewardSet;

    public LadderGame(Ladder ladder, UserRewardSet userRewardSet) {
        this.ladder = ladder;
        this.userRewardSet = userRewardSet;
    }

    public String ladderBoard(){
        return ladder.toString();
    }

    public LadderGameResult ladderResult(){
        return new LadderGameResult(userRewardSet, ladder.playResult());
    }
}
