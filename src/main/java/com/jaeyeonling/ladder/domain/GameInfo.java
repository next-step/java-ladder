package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.ladder.LadderResult;
import com.jaeyeonling.ladder.domain.ladder.LadderResults;
import com.jaeyeonling.ladder.domain.user.CountOfUsers;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotEqualsUserSizeAndResultSizeException;

import java.util.stream.Stream;

public class GameInfo {

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

    public Stream<User> userStream() {
        return users.stream();
    }

    public CountOfUsers getCountOfUsers() {
        return users.getCountOfUsers();
    }

    public int findUserIndexByUsername(final String usernameOfWantResult) {
        return users.findIndexByUsername(usernameOfWantResult);
    }

    public LadderResult findLadderResultByIndex(final int indexOfResult) {
        return ladderResults.findByIndex(indexOfResult);
    }
}
