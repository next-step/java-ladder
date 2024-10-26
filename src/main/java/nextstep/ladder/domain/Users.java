package nextstep.ladder.domain;

import nextstep.ladder.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

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

    public String getUsersAsString() {
        return users.stream()
                .map(it -> StringUtils.lPad(it.getName(), 6))
                .collect(Collectors.joining());
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
}
