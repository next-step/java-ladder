package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.Index;
import com.jaeyeonling.ladder.domain.reword.LadderReword;
import com.jaeyeonling.ladder.domain.reword.LadderRewords;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.exception.NotEqualsUserSizeAndRewordSizeException;

import java.util.stream.IntStream;

public class GameInfo {

    private final Users users;
    private final LadderRewords ladderRewords;

    private GameInfo(final Users users,
                     final LadderRewords ladderRewords) {
        this.users = users;
        this.ladderRewords = ladderRewords;
    }

    static GameInfo with(final Users users,
                         final LadderRewords ladderRewords) {
        if (users.size() != ladderRewords.size()) {
            throw new NotEqualsUserSizeAndRewordSizeException(users.size(), ladderRewords.size());
        }

        return new GameInfo(users, ladderRewords);
    }

    public Users getUsers() {
        return users;
    }

    LadderRewords getLadderRewords() {
        return ladderRewords;
    }

    IntStream range() {
        return IntStream.range(0, users.size());
    }

    Username findUsernameBy(final Index index) {
        return users.findUsernameBy(index.getIndex());
    }

    LadderReword findLadderRewordBy(final Index index) {
        return ladderRewords.findLadderRewordBy(index.getIndex());
    }
}
