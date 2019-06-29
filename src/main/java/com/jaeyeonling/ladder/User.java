package com.jaeyeonling.ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {

    private static final Map<Username, User> CACHE = new HashMap<>();

    private final Username username;

    private User(final Username username) {
        this.username = username;
    }

    public static User of(final String username) {
        return of(Username.of(username));
    }

    public static User of(final Username username) {
        return CACHE.computeIfAbsent(username, User::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }

        final User that = (User) o;
        return Objects.equals(this.username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }
}
