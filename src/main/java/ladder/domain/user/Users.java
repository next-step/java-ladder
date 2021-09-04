package ladder.domain.user;

import static ladder.util.StringUtil.containsComma;
import static ladder.util.StringUtil.splitByComma;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public static Users of(String usernames) {
        checkUserCount(usernames);

        return new Users(Arrays.stream(splitByComma(usernames))
            .map(User::new)
            .collect(Collectors.toList()));
    }

    public static void checkUserCount(String usernames) {
        if (!containsComma(usernames)) {
            throw new IllegalArgumentException("사람의 수는 2명이상이 들어와야 한다.");
        }
    }

    public int userCount() {
        return users.size();
    }

    public void shuffleUsers() {
        Collections.shuffle(users);
    }

    public List<User> value() {
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
