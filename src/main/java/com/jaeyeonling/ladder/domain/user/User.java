package com.jaeyeonling.ladder.domain.user;

import com.jaeyeonling.ladder.utils.StringUtils;
import com.jaeyeonling.ladder.view.StringVisualizable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User implements StringVisualizable {

    private static final Map<Username, User> POOL = new HashMap<>();

    private final Username username;

    private User(final Username username) {
        this.username = username;
    }

    public static User of(final String username) {
        return POOL.computeIfAbsent(Username.valueOf(username), User::new);
    }

    public Username getUsername() {
        return username;
    }

    boolean equalsUsername(final Username username) {
        return this.username.equals(username);
    }

    @Override
    public String visualize() {
        return StringUtils.rightAlign(username.visualize(), Username.MAX_LENGTH);
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
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
