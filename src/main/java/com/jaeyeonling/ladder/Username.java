package com.jaeyeonling.ladder;

class Username {

    private final String username;

    private Username(final String username) {
        this.username = username;
    }

    public static Username of(final String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return new Username(username);
    }
}
