package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderResult;
import com.jaeyeonling.ladder.domain.ladder.LadderResults;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotEqualsUserSizeAndResultSizeException;

import java.util.stream.Stream;

public class GameInfo {

    static final String FINISH_CHARACTER = "all";

    private final Users users;
    private final LadderResults ladderResults;

    private GameInfo(final Users users,
                     final LadderResults ladderResults) {
        this.users = users;
        this.ladderResults = ladderResults;
    }

    public static GameInfo withUsersAndLadderResults(final Users users,
                                                     final LadderResults ladderResults) {
        if (users.size() != ladderResults.size()) {
            throw new NotEqualsUserSizeAndResultSizeException(users.size(), ladderResults.size());
        }

        return new GameInfo(users, ladderResults);
    }

    public boolean isShowAll(final String usernameOfWantResult) {
        return FINISH_CHARACTER.equalsIgnoreCase(usernameOfWantResult);
    }

    public LadderResult findWinningResult(final String usernameOfWantResult,
                                          final LadderGame ladderGame) {
        final int indexOfLadder = users.findIndexByUsername(usernameOfWantResult);
        final int indexOfResult = ladderGame.ride(indexOfLadder);

        return ladderResults.findByIndex(indexOfResult);
    }

    public Stream<User> userStream() {
        return users.stream();
    }
}
