package com.fineroot.ladder.domain;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;

    public LadderGame(Ladder ladder, Users users) {
        this.ladder = ladder;
        this.users = users;
    }

    public String ladderBoard(){
        return ladder.toStringBoard(users.firstUsernameLength());
    }
}
