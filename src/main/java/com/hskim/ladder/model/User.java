package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class User {

    private UserName userName;

    public User(UserName userName) {
        this.userName = userName;
    }

    public static List<User> makeUsersFromNames(List<UserName> userNames) {
        return userNames.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
