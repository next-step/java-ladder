package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.utils.StringUtils;

class Username {

    private final String username;

    private Username(final String username) {
        this.username = username;
    }

    public static Username of(final String username) {
        if (StringUtils.isNullOrEmpty(username)) {
            throw new IllegalArgumentException();
        }

        return new Username(username);
    }
}
