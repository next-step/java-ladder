package com.jaeyeonling.ladder;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    static final String SEPARATOR = ",";

    private final List<User> users;

    private Users(final List<User> users) {
        this.users = users;
    }

    public static Users of(final String rawUsers) {
        final List<User> users = Arrays.stream(rawUsers.split(SEPARATOR))
                .map(User::of)
                .collect(Collectors.toList());

        return new Users(users);
    }

    int size() {
        return users.size();
    }
}
