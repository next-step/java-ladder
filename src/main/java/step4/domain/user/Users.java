package step4.domain.user;

import static step4.util.StringUtil.containsComma;
import static step4.util.StringUtil.splitByComma;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import step4.exception.user.UsersCountException;

public class Users {

    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    static Users of(List<User> users) {
        return new Users(users);
    }

    public static Users of(String usernames) {
        checkUsersCount(usernames);

        return new Users(Arrays.stream(splitByComma(usernames))
            .map(User::of)
            .collect(Collectors.toList()));
    }

    private static void checkUsersCount(String usernames) {
        if (!containsComma(usernames)) {
            throw new UsersCountException();
        }
    }

    public int usersCount() {
        return users.size();
    }

    public User userByPosition(int position) {
        return users.get(position);
    }

    public List<User> values() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
