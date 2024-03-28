package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

    public static final int MINIMUM_USERS_COUNT = 2;
    private final List<User> users;

    public static Users of(List<String> users) {
        return new Users(users);
    }

    private Users(List<String> users) {
        validate(users);
        this.users = users.stream()
                .map(User::of)
                .collect(Collectors.toList());
    }

    private void validate(List<String> users) {
        if (users.size() < MINIMUM_USERS_COUNT) {
            throw new IllegalArgumentException("참여자는 2명 이상이여야 합니다.");
        }
    }

    public List<String> toNameList() {
        return users.stream()
                .map(User::name)
                .collect(Collectors.toList());
    }
}
