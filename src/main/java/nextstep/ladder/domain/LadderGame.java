package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

public class LadderGame {

    private final Users users;
    private final Ladder ladder;
    private final LadderGoalBoard ladderGoalBoard;

    public LadderGame(Users users, LadderHeight height, LadderGoalBoard ladderGoalBoard) {
        throwIfNull(users, ladderGoalBoard);
        throwIfInvalidLadderGame(users, ladderGoalBoard);
        this.users = users;
        this.ladder = new Ladder(users, height);
        this.ladderGoalBoard = ladderGoalBoard;
    }

    private void throwIfNull(Users users, LadderGoalBoard ladderGoalBoard) {
        if (users == null || ladderGoalBoard == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_GAME);
        }
    }

    private void throwIfInvalidLadderGame(Users users, LadderGoalBoard ladderGoalBoard) {
        if (users.size() != ladderGoalBoard.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_GAME);
        }
    }


    public Users getUsers() {
        return users;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
