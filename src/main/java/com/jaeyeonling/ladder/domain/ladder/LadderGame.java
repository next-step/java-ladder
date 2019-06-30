package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.user.Users;

public class LadderGame {

    private final Users users;
    private final Lines lines;

    private LadderGame(final Users users,
                       final Lines lines) {
        this.users = users;
        this.lines = lines;
    }

    public static LadderGame of(final Users users,
                                final Lines lines) {
        return new LadderGame(users, lines);
    }

    public Users getUsers() {
        return users;
    }

    public Lines getLines() {
        return lines;
    }
}
