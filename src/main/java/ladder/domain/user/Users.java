package ladder.domain.user;

import static ladder.util.StringUtil.splitByComma;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users of(String usernames) {
        return new Users(Arrays.stream(splitByComma(usernames))
            .map(User::new)
            .collect(Collectors.toList()));
    }

    public int userCount() {
        return users.size();
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
