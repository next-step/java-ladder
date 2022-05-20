package nextstep.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private static final int MIN_USER_SIZE = 2;
    private static final int NOT_FOUND_USER = -1;
    private final List<User> users;

    public Users(List<User> users) {
        validate(users);
        this.users = users;
    }

    private void validate(List<User> users) {
        if (users.size() < MIN_USER_SIZE) {
            throw new IllegalArgumentException("유저 수는 최소 2명 이상이여야 합니다.");
        }
        if (users.stream()
                .anyMatch(user -> checkSameUser(users, user))) {
            throw new IllegalArgumentException("동일한 이름을 가진 유저를 포함할 수 없습니다.");
        }
    }

    private boolean checkSameUser(List<User> users, User user) {
        return users.stream()
            .filter(u -> u.getUserName().equals(user.getUserName()))
            .count() > 1;
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int getUserSize() {
        return users.size();
    }

    public Integer findUsernameIndex(String username) {
        return this.users.stream()
            .filter(user -> user.getUserName().equals(username))
            .map(this.users::indexOf)
            .findFirst()
            .orElse(NOT_FOUND_USER);
    }

    public List<String> findAll(Ladder ladder) {
        return this.users
            .stream()
            .map(u -> ladder.find(findUsernameIndex(u.getUserName())))
            .collect(Collectors.toList());
    }

}
