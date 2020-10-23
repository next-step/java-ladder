package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users ofByRaw(String usersRaw) {
        String[] splitUsersRaw = usersRaw.split(",");
        List<User> users = new ArrayList<>();
        for (String personRaw : splitUsersRaw) {
            users.add(new User(users.size(), personRaw.trim()));
        }
        return new Users(users);
    }
    public List<User> getUsers() {
        return users;
    }

    public int size() {
        return users.size();
    }

    public int countOfUsers() {
        return users.size();
    }

    public int getMaxUserNameLength() {
        User max = Collections.max(users);
        return max.getName().length();
    }

    public String findUsernameByIdx(int idx) {
        return users.get(idx).getName();
    }

    public int getIdxByUsername(String username) {
        User findUser = users.stream()
                .filter(user -> user.getName().equals(username))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력하신 유저이름이 없습니다."));
        return findUser.getOrder();
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
