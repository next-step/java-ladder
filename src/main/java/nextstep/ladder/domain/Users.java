package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        validateDuplicateUserName(users);
        this.users = users;
    }

    private void validateDuplicateUserName(List<User> users) {
        if (getDistinctUserCount(users) != users.size()) {
            throw new IllegalArgumentException("이름이 같은 회원이 포함되어 있습니다.");
        }
    }

    private long getDistinctUserCount(List<User> users) {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toSet())
                .size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int size() {
        return users.size();
    }
}
