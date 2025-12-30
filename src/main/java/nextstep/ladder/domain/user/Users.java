package nextstep.ladder.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Users {

    private final List<User> users;

    public Users(String names) {
        this(validateName(names).split(","));
    }

    public Users(String[] names) {
        this(Arrays.stream(names).map(User::new).toList());
    }

    public Users(List<User> users) {
        this.users = users;
    }

    private static String validateName(String names) {
        if (Objects.isNull(names) || names.isEmpty()) {
            throw new IllegalArgumentException("참여자 입력은 필수입니다.");
        }
        return names;
    }

    public List<User> getUsers() {
        return users;
    }

    public int size() {
        return users.size();
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
