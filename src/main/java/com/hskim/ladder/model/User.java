package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class User {
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String EXCEED_NAME_LENGTH_LIMIT = "유저 이름은 " + NAME_LENGTH_LIMIT + "자를 초과할 수 없습니다.";
    private static final String EMPTY_NAME = "유저 이름은 공백이 될 수 없습니다.";

    private final String name;

    public User(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(EXCEED_NAME_LENGTH_LIMIT);
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME);
        }
    }

    public static List<User> makeUserFromNames(List<String> names) {
        return names.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
