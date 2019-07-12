package com.jaeyeonling.ladder.domain.user;

import com.jaeyeonling.ladder.exception.DuplicateUsernameException;
import com.jaeyeonling.ladder.exception.NotFoundUserException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {

    public static final String SEPARATOR = "\\s*,\\s*";

    private final List<User> users;

    private Users(final List<User> users) {
        this.users = new ArrayList<>(users);
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

    public int size() {
        return this.users.size();
    }

    public Username findUsernameBy(final int index) {
        return users.get(index).getUsername();
    }

    public int findIndexBy(final Username username) {
        final User user = users.stream()
                .filter(u -> u.equalsUsername(username))
                .findFirst()
                .orElseThrow(() -> new NotFoundUserException(username));

        return users.indexOf(user);
    }

    public Stream<User> stream() {
        return users.stream();
    }
}
