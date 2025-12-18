package nextstep.ladder.domain;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Users {

    private List<User> users;

    public Users(String names) {
        this(Arrays.stream(validateName(names)
                        .split(","))
                .map(User::new)
                .toList());
    }

    public Users(List<User> users) {
        this.users = users;
    }

    private static String validateName(String names) {
        if (Objects.isNull(names) || names.isEmpty()) {
            throw new IllegalArgumentException("참여자는 입력은 필수입니다.");
        }
        return names;
    }

    public List<User> getUsers() {
        return users;
    }
}
