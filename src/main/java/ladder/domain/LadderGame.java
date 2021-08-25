package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.Users;
import ladder.exception.LadderLackOfUserException;

public final class LadderGame {

    public static final int MIN_USER_COUNT = 2;

    private final Users users;

    public LadderGame(final String[] users) {
        validateUserCount(users);
        this.users = new Users(users);
    }

    private void validateUserCount(final String[] users) {
        if (users.length < MIN_USER_COUNT) {
            throw new LadderLackOfUserException();
        }
    }

    public Ladder generateLadder(final int ladderHeight, final DirectionStrategy directionStrategy) {
        return new Ladder(directionStrategy, ladderHeight, users.getUserCount());
    }
}
