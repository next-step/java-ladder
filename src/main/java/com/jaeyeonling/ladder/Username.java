package com.jaeyeonling.ladder;

class Username {

    private final String username;

    private Username(final String username) {
        this.username = username;
    }

    public static Username of(final String username) {
        return new Username(username);
    }
}
