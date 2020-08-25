package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderUsers {

    private List<User> users;

    public LadderUsers(List<User> users) {
        this.users = users;
    }

    public int getUserNumber() {
        return users.size();
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getUserName)
                .map(UserName::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderUsers)) return false;
        LadderUsers that = (LadderUsers) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
