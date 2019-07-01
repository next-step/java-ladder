package com.jaeyeonling.ladder.domain.user;


import com.jaeyeonling.ladder.exception.DuplicateUsernameException;
import com.jaeyeonling.ladder.exception.NotFoundUserException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {

    static final String SEPARATOR = "\\s*,\\s*";

    private final List<User> users;

    private Users(final List<User> users) {
        this.users = users;
    }

    public static Users ofSeparator(final String rawUsers) {
        final int rawUsersSize = rawUsers.split(SEPARATOR).length;

        final List<User> users = Arrays.stream(rawUsers.split(SEPARATOR))
                .distinct()
                .map(User::of)
                .collect(Collectors.toList());

        if (rawUsersSize != users.size()) {
            throw new DuplicateUsernameException();
        }

        return new Users(users);
    }

    public Stream<User> stream() {
        return users.stream();
    }

    public int findIndexByUsername(final Username username) {
        return this.users.stream()
                .filter(u -> u.equalsUsername(username))
                .findFirst()
                .map(this::findIndexByUser)
                .orElseThrow(() -> new NotFoundUserException(username.getUsername()));
    }

    public int findIndexByUser(final User user) {
        return this.users.indexOf(user);
    }

    public int size() {
        return this.users.size();
    }

    public CountOfUsers getCountOfUsers() {
        return CountOfUsers.fromUsers(this);
    }
}
