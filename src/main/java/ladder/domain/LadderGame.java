package ladder.domain;

import ladder.domain.ladder.DirectionStrategy;
import ladder.domain.ladder.Ladder;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import ladder.exception.LadderGameDifferentSizeException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LadderGame {

    private final Users users;
    private final Results results;

    public LadderGame(final List<String> users, final List<String> results) {
        validateSameSize(users, results);

        this.users = new Users(users);
        this.results = new Results(results);
    }

    private void validateSameSize(final List<String> users, final List<String> results) {
        if(users.size() != results.size()) {
            throw new LadderGameDifferentSizeException();
        }
    }

    public Ladder generateLadder(final int ladderHeight, final DirectionStrategy directionStrategy) {
        return new Ladder(directionStrategy, ladderHeight, users.getUserCount());
    }

    public LadderGameResult execute(final Ladder ladder) {
        Map<User, Result> resultMap = new HashMap<>();
        for (int i = 0; i < users.getUserCount(); i++) {
            int endPoint = ladder.run(i);
            resultMap.put(users.get(i), results.get(endPoint));
        }
        return new LadderGameResult(resultMap);
    }
}