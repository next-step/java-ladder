package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import nextstep.ladder.util.StringUtils;

public class Users {
    private final LinkedHashSet<User> users;

    private Users(LinkedHashSet<User> users) {
        this.users = users;
    }

    public static Users from(Set<String> userNames) {
        LinkedHashSet<User> userSet = userNames.stream()
            .map(User::new)
            .collect(Collectors.toCollection(LinkedHashSet::new));
        return new Users(userSet);
    }

    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }

    public int size() {
        return users.size();
    }

    public User findUserByName(String name) {
        return users.stream()
            .filter(user -> user.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("존재하지 않는 유저 입니다."));
    }

    public int findUserIndex(User user) {
        return new ArrayList<>(users).indexOf(user);
    }

    @Override
    public String toString() {
        return users.stream()
            .map(it -> StringUtils.lPad(it.getName(), 6))
            .collect(Collectors.joining());
    }
}
