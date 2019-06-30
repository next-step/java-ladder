package com.jaeyeonling.ladder.domain.user;

import com.jaeyeonling.ladder.domain.Positive;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountOfUsers {

    private static final Map<Positive, CountOfUsers> CACHE = new HashMap<>();

    private final Positive countOfUsers;

    private CountOfUsers(final Positive countOfUsers) {
        this.countOfUsers = countOfUsers;
    }

    static CountOfUsers fromUsers(final Users users) {
        return valueOf(Positive.valueOf(users.size()));
    }

    static CountOfUsers valueOf(final Positive countOfUsers) {
        return CACHE.computeIfAbsent(countOfUsers, CountOfUsers::new);
    }

    public int getValue() {
        return countOfUsers.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CountOfUsers)) {
            return false;
        }

        final CountOfUsers that = (CountOfUsers) o;
        return Objects.equals(this.countOfUsers, that.countOfUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.countOfUsers);
    }
}
