package com.jaeyeonling.ladder.domain.user;

import com.jaeyeonling.ladder.exception.EmptyUsernameException;
import com.jaeyeonling.ladder.exception.LongerThanMaxLengthUsernameException;
import com.jaeyeonling.ladder.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Username {

    private static final Map<String, Username> CACHE = new HashMap<>();

    public static final int MAX_LENGTH = 5;

    private final String username;

    private Username(final String username) {
        this.username = username;
    }

    public static Username of(final String username) {
        if (StringUtils.isNullOrEmpty(username)) {
            throw new EmptyUsernameException();
        }
        if (username.length() > MAX_LENGTH) {
            throw new LongerThanMaxLengthUsernameException(username);
        }

        return CACHE.computeIfAbsent(username, Username::new);
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Username)) {
            return false;
        }

        final Username that = (Username) o;
        return Objects.equals(this.username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }
}
