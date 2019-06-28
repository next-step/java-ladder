package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.exception.EmptyUsernameException;
import com.jaeyeonling.ladder.utils.StringUtils;

class Username {

    static final int MAX_LENGTH = 5;

    private final String username;

    private Username(final String username) {
        this.username = username;
    }

    public static Username of(final String username) {
        if (StringUtils.isNullOrEmpty(username)) {
            throw new EmptyUsernameException();
        }

        return new Username(username);
    }
}
