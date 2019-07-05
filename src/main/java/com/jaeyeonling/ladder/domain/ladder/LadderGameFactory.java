package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.GameInfo;
import com.jaeyeonling.ladder.domain.user.Users;

public final class LadderGameFactory {

    private LadderGameFactory() { }

    public static LadderGame create(final Users users,
                                    final LadderRewords ladderRewords) {
        final GameInfo gameInfo = GameInfo.withUsersAndLadderRewords(users, ladderRewords);

        return LadderGame.of(gameInfo);
    }
}
