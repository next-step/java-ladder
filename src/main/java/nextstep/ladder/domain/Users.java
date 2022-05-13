package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Users {
    private static final String DUPLICATED_NAME_ERROR = "이름이 중복되었습니다.";
    private final List<User> users;

    public Users(List<User> users) {
        validate(users);
        this.users = users;
    }

    private void validate(List<User> users) {
        HashSet<User> userSet = new HashSet<>(users);
        if (userSet.size() != users.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
        }
    }

    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        for (User user : users) {
            userNames.add(user.toString());
        }
        return userNames;
    }

    public int size() {
        return users.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
