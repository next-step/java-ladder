package com.jaeyeonling.ladder;

import java.util.List;

public class Users {



    private final List<User> users;

    private Users(final List<User> users) {
        this.users = users;
    }

    public static Users of(String rawUsers) {
        return new Users(List.of(User.of(rawUsers)));
    }
}
