package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.user.Users;
import ladder.exception.LadderLackOfUserException;

import java.util.List;

public final class LadderGame {

    public static final int MIN_USER_COUNT = 2;

    private final Users users;
    private final Results results;

    public LadderGame(final List<String> users, List<String> results) {
        validateUserCount(users);
        this.users = new Users(users);
        this.results = new Results(results);
    }

    private void validateUserCount(final List<String> users) {
        if (users.size() < MIN_USER_COUNT) {
            throw new LadderLackOfUserException();
        }
    }

    public Ladder generateLadder(final int ladderHeight, final DirectionStrategy directionStrategy) {
        return new Ladder(directionStrategy, ladderHeight, users.getUserCount());
    }

    public Result executionLadderGame(Ladder ladder, String username) {
        int startPosition = users.indexOf(username);
        int resultIndex = ladder.run(startPosition);
        return results.get(resultIndex);
    }
}
