package ladder.domain;

import java.util.List;

public class Users {
    private static final int MIN_SIZE = 2;
    private static final String DUPLICATE_USER_ERROR = "사용자 이름은 중복될 수 없습니다.";
    private static final String MIN_SIZE_ERROR = "사용자는 " + MIN_SIZE + "명 이상이어야 합니다.";

    private final List<UserName> users;

    public Users(List<UserName> users) {
        validateSize(users);
        validateDuplicated(users);
        this.users = users;
    }

    private void validateSize(List<UserName> users) {
        if (users.size() < MIN_SIZE) {
            throw new IllegalArgumentException(MIN_SIZE_ERROR);
        }
    }

    private void validateDuplicated(List<UserName> users) {
        if (users.size() != users.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_USER_ERROR);
        }
    }

    public int size() {
        return users.size();
    }
}
