package com.jaeyeonling.ladder;

public class User {

    private final Username username;

    private User(final Username username) {
        this.username = username;
    }

    public static User of(final String username) {
        return of(Username.of(username));
    }

    public static User of(final Username username) {
        return new User(username);
    }
}
