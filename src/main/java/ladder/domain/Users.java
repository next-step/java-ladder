package ladder.domain;

import java.util.List;

public class Users {
    private static final String DUPLICATE_USER_ERROR = "사용자 이름은 중복될 수 없습니다.";

    private final List<UserName> users;

    public Users(List<UserName> users) {
        validateDuplicated(users);
        this.users = users;
    }

    private void validateDuplicated(List<UserName> users) {
        if (users.size() != users.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
    public int size() {
        return users.size();
    }
}
