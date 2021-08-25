package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.user.Users;

import java.util.List;

public final class LadderGame {

    private final Users users;
    private final Results results;

    public LadderGame(final List<String> users, final List<String> results) {
        this.users = new Users(users);
        this.results = new Results(results);
    }

    public Ladder generateLadder(final int ladderHeight, final DirectionStrategy directionStrategy) {
        return new Ladder(directionStrategy, ladderHeight, users.getUserCount());
    }

    public Result executionLadderGame(final Ladder ladder, final String username) {
        int startPosition = users.indexOf(username);
        int resultIndex = ladder.run(startPosition);
        return results.get(resultIndex);
    }
}
