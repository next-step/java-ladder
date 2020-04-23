package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users {
    private static final String REQUIRE_USERS = "사용자의 값이 입력되어야합니다";
    private static final String NOT_FOUND_USER = "검색 결과가 없습니다.";

    private final List<User> users;

    public Users(final List<User> users) {
        this.users = validateUsers(users);
    }

    public List<User> validateUsers(final List<User> users) {
        if (users.isEmpty()) {
            throw new IllegalArgumentException(REQUIRE_USERS);
        }
        return new ArrayList<>(users);
    }

    public List<User> getUsers() {
        return users;
    }

    public String getUserName(int index) {
        return users.get(index).getName();
    }

    public int index(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return i;
            }
        }
        throw new IllegalArgumentException(NOT_FOUND_USER);
    }

    public User findUser(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)) {
                return users.get(i);
            }
        }

        throw new IllegalArgumentException(NOT_FOUND_USER);
    }

    public int size() {
        return users.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
