package step2.domain;

import java.util.List;

public class Users {
    public static final int MIN_USER = 2;
    public static final int MAX_FULL_NAME = 5;
    private final List<String> users;

    public Users(List<String> users) {
        validateUser(users);
        this.users = users;
    }

    private void validateUser(List<String> users) {
        if (users.size() < MIN_USER) {
            throw new IllegalArgumentException("사용자는 최소 2명 이상이여야 합니다. (입력된 사용자 수: " + users.size() + "명)");
        }
        if (users.stream().anyMatch(s -> s.length() > MAX_FULL_NAME)) {
            throw new IllegalArgumentException("사용자 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public List<String> getUsers() {
        return users;
    }
}
