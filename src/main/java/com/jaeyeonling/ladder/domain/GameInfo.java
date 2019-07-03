package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.ladder.LadderReword;
import com.jaeyeonling.ladder.domain.ladder.LadderRewords;
import com.jaeyeonling.ladder.domain.user.CountOfUsers;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotEqualsUserSizeAndRewordSizeException;

import java.util.stream.Stream;

public class GameInfo {

    private final Users users;
    private final LadderRewords ladderRewords;

    private GameInfo(final Users users,
                     final LadderRewords ladderRewords) {
        this.users = users;
        this.ladderRewords = ladderRewords;
    }

    public static GameInfo withUsersAndLadderRewords(final Users users,
                                                     final LadderRewords ladderRewords) {
        if (users.size() != ladderRewords.size()) {
            throw new NotEqualsUserSizeAndRewordSizeException(users.size(), ladderRewords.size());
        }

        return new GameInfo(users, ladderRewords);
    }

    public Stream<User> userStream() {
        return users.stream();
    }

    public CountOfUsers getCountOfUsers() {
        return users.getCountOfUsers();
    }

    public int findUserIndexByUsername(final String usernameOfWantReword) {
        return users.findIndexByUsername(usernameOfWantReword);
    }

    public LadderReword findLadderRewordByIndex(final int indexOfReword) {
        return ladderRewords.findByIndex(indexOfReword);
    }
}
