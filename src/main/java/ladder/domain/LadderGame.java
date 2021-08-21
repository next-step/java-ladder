package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import ladder.exception.LadderLackOfUserException;
import ladder.exception.LadderMinimumHeightException;

public final class LadderGame {

    public static final int MAX_USERNAME_LENGTH = 5;
    public static final int MIN_USER_COUNT = 2;

    private final int ladderHeight;
    private final String[] users;

    public LadderGame(final int ladderHeight, final String... users) {
        validateLadderHeight(ladderHeight);
        validateUserCount(users);

        this.ladderHeight = ladderHeight;
        this.users = users;
    }

    private void validateLadderHeight(final int ladderHeight) {
        if (ladderHeight < Ladder.MIN_HEIGHT) {
            throw new LadderMinimumHeightException(ladderHeight);
        }
    }

    private void validateUserCount(final String[] users) {
        if (users.length < MIN_USER_COUNT) {
            throw new LadderLackOfUserException();
        }
    }

    public Ladder start(final DirectionStrategy directionStrategy) {
        return new Ladder(directionStrategy, ladderHeight, users.length);
    }
}
